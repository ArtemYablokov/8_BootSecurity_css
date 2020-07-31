package com.yabloko.security.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("com.yabloko")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

//    @Qualifier("userDetailsServiceImpl")
    UserDetailsService userDetailsService;
    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**");
//        super.configure(web);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/users/**").hasAuthority("ADMIN")
                    .antMatchers("/signUp/**").permitAll()
                    .antMatchers("/css/**").permitAll()
//                    .antMatchers("/static/**").permitAll()
//                    .antMatchers("/static/css/styles.css").permitAll()
                    .antMatchers("/").authenticated()
//                .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .usernameParameter("login")
                    .defaultSuccessUrl("/profile")
                    .loginPage("/login")
                .permitAll()
                .and()
                    .rememberMe()
                    .rememberMeParameter("remember-me")
                    .tokenRepository(tokenRepository());

//        http.csrf().disable();
    }

    @Override
    protected void configure(/*@NotNull*/ AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

}
