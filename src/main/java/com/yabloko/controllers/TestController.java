package com.yabloko.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Value("${test.string}")
    private String testString;

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("testString", testString);
        return "test";
    }
}