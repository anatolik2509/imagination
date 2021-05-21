package ru.itis.antonov.imagination.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    @Value("${oauth.github.client-id}")
    private String clientId;

    @GetMapping("/signIn")
    public String getView(Model model){
        model.addAttribute("clientId", clientId);
        return "signIn";
    }

    @GetMapping(value = "/signIn", params = {"error"})
    public String getViewWithError(Model model){
        model.addAttribute("error", true);
        model.addAttribute("clientId", clientId);
        return "signIn";
    }

}
