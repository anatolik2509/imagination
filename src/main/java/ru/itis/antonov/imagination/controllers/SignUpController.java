package ru.itis.antonov.imagination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.antonov.imagination.dto.form.SignUpForm;

@Controller
public class SignUpController {
    @GetMapping("/signUp")
    public String getView(){
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpForm form){
        return "sign_up";
    }
}
