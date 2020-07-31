package com.yabloko.controllers;

import com.yabloko.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserSaveService userSaveService;

    @GetMapping("/login")
    public String login(Authentication authentication, HttpServletRequest httpServletRequest, ModelMap modelMap){
        if (authentication != null)
            return "redirect:/profile";
        // Использем HttpServletRequest вместо RequestParam так как он не видит параметры без значения
        if (httpServletRequest.getParameterMap().containsKey("error"))
            modelMap.addAttribute("error", true);
        return "login";
    }
}