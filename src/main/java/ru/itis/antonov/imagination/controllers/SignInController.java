package ru.itis.antonov.imagination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getView(){
        return "signIn";
    }

    @GetMapping(value = "/signIn", params = {"error"})
    public String getViewWithError(Model model){
        model.addAttribute("error", true);
        return "signIn";
    }

}
