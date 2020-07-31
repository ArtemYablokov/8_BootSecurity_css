package com.yabloko.controllers;

import com.yabloko.dto.UserDto;
import com.yabloko.security.details.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static com.yabloko.dto.UserDto.from;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        // необязательно - аутентификация работает авто
//        if (authentication == null) {
//            return "redirect:/login";
//        }
        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";

    }
}