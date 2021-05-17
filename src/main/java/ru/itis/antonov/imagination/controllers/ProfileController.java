package ru.itis.antonov.imagination.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import ru.itis.antonov.imagination.dto.UserDto;
import ru.itis.antonov.imagination.dto.form.UserUpdateForm;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.UserService;

@Controller
public class ProfileController {

    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getView(Model model, @AuthenticationPrincipal UserDetailsModelImpl userDetails){
        UserDto user = userService.getUserById(userDetails.getUser().getId());
        model.addAttribute("account", user);
        return "profile";
    }

    @GetMapping("/profile/edit")
    public String getEditView(){
        return "profileEdit";
    }

    @PatchMapping("/profile/edit")
    public String edit(UserUpdateForm form,  @AuthenticationPrincipal UserDetailsModelImpl userDetails, Model model){
        UserDto user = userService.updateUser(form, userDetails.getUser().getId());
        model.addAttribute("account", user);
        return "profile";
    }
}
