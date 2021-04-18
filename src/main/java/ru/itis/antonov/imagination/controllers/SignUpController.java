package ru.itis.antonov.imagination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public String getView(){
        return "sign_up";
    }
}
