package com.yabloko.models;

import com.yabloko.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "apple_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    public static User buildFromForm(UserForm userForm){
        return User.builder()
                .firstName(userForm.getFirstName())
                .login(userForm.getLogin())
                .password(userForm.getPassword())
                .build();
    }
}