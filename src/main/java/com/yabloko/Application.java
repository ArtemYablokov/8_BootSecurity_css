package com.yabloko;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = "com.yabloko")
@EnableJpaRepositories(basePackages = "com.yabloko.repository")
@EntityScan(basePackages = "com.yabloko.models")
public class Application {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public static void main(String[] args) {
//        System.out.println(User.builder().firstName("a").build().getFirstName());
        SpringApplication.run(Application.class);
    }
}