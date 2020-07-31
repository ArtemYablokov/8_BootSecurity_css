package com.yabloko.controllers;

import com.yabloko.forms.UserForm;
import com.yabloko.service.UserSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    UserSaveService userSaveService;

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpSave(UserForm userForm){
        userSaveService.save(userForm);
        return "redirect:/login";
    }

}
