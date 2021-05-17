package ru.itis.antonov.imagination.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.antonov.imagination.dto.form.SignUpForm;
import ru.itis.antonov.imagination.exception.OccupiedEmailException;
import ru.itis.antonov.imagination.repositories.UserRepository;
import ru.itis.antonov.imagination.services.interfaces.UserService;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signUp")
    public String getView(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errorList", result.getAllErrors());
            return "signUp";
        }
        try {
            userService.addUser(form);
        }
        catch (OccupiedEmailException e){
            model.addAttribute("emailError", true);
            return "signUp";
        }
        //todo authentication on sign up
        return "signUp";
    }
}
