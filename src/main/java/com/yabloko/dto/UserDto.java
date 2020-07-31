package com.yabloko.dto;

import com.yabloko.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String login;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .login(user.getLogin())
                .build();
    }
}
