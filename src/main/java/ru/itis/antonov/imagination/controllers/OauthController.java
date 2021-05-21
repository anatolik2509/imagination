package ru.itis.antonov.imagination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.antonov.imagination.models.OauthToken;
import ru.itis.antonov.imagination.services.interfaces.OauthTokenService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class OauthController {
    private OauthTokenService tokenService;

    public OauthController(OauthTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/oauth")
    public String authorize(@RequestParam String code, HttpServletResponse response){
        OauthToken token;
        try {
            token = tokenService.getToken(code);
        }
        catch (IllegalArgumentException e){
            return "redirect:/login";
        }
        response.addCookie(new Cookie("oauth_token", token.getValue()));
        return "redirect:/profile";
    }
}
