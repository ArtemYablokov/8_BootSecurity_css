package com.yabloko.service;

import com.yabloko.models.Role;
import com.yabloko.models.State;
import com.yabloko.models.User;
import com.yabloko.forms.UserForm;
import com.yabloko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSaveFormService implements UserSaveService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(UserForm userform) {
        String hashPassword = passwordEncoder.encode(userform.getPassword());
        User user = User.builder()
                .firstName(userform.getFirstName())
                .login(userform.getLogin())
                .password(hashPassword)
                .build();
        user.setRole(Role.USER);
        user.setState(State.ACTIVE);
        userRepository.save(user);
    }
}
