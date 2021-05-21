package ru.itis.antonov.imagination.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.antonov.imagination.dto.UserDto;
import ru.itis.antonov.imagination.dto.form.UserUpdateForm;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ProfileController {

    private final UserService userService;

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

    @PostMapping("/profile/edit")
    public String edit(UserUpdateForm form,  @AuthenticationPrincipal UserDetailsModelImpl userDetails, Model model){
        UserDto user = userService.updateUser(form, userDetails.getUser().getId());
        model.addAttribute("account", user);
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String getProfileById(Model model, @AuthenticationPrincipal UserDetailsModelImpl userDetails, @PathVariable Long id){
        UserDto user = userService.getUserById(id, userDetails.getUser().getId());
        model.addAttribute("account", user);
        return "profile";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/profile/ban")
    public void banProfileById(@RequestParam Long userId, HttpServletResponse response){
        userService.banUser(userId);
        response.setStatus(200);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/profile/unban")
    public void unbanProfileById(@RequestParam Long userId, HttpServletResponse response){
        userService.banUser(userId);
        response.setStatus(200);
    }


    @PostMapping("/profile/subscribe")
    public void subscribe(@AuthenticationPrincipal UserDetailsModelImpl userDetails,
                          @RequestParam Long userId,
                          HttpServletResponse response){
        userService.subscribe(userDetails.getUser().getId(), userId);
        response.setStatus(200);
    }

    @PostMapping("/profile/unsubscribe")
    public void unsubscribe(@AuthenticationPrincipal UserDetailsModelImpl userDetails,
                          @RequestParam Long userId,
                          HttpServletResponse response){
        userService.unsubscribe(userDetails.getUser().getId(), userId);
        response.setStatus(200);
    }
}
