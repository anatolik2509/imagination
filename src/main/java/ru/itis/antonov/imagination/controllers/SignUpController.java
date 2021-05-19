package ru.itis.antonov.imagination.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.antonov.imagination.dto.form.SignUpForm;
import ru.itis.antonov.imagination.exception.OccupiedEmailException;
import ru.itis.antonov.imagination.repositories.UserRepository;
import ru.itis.antonov.imagination.services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class SignUpController {

    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signUp")
    public String getView(Model model){
        model.addAttribute("form",
                SignUpForm.builder().email("").password("").passwordRepeat("").nickname("").build());
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult result, Model model, HttpServletRequest request){
        if(result.hasErrors()){
            System.out.println(result.getAllErrors().get(0).shouldRenderDefaultMessage());
            model.addAttribute("errorList", result.getAllErrors());
            model.addAttribute("form", form);
            return "signUp";
        }
        try {
            userService.addUser(form);
            request.login(form.getEmail(), form.getPassword());
        }
        catch (OccupiedEmailException e){
            model.addAttribute("emailError", true);
            model.addAttribute("form", form);
            return "signUp";
        }
        catch (ServletException e){
            return "redirect:/signIn";
        }
        return "redirect:/profile";
    }

}
