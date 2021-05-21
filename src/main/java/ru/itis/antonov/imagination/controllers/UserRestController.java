package ru.itis.antonov.imagination.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.antonov.imagination.dto.UserDto;
import ru.itis.antonov.imagination.dto.form.SignUpForm;
import ru.itis.antonov.imagination.services.interfaces.UserService;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody SignUpForm form){
        userService.registerUser(form);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/users")
    public ResponseEntity<?> banUser(@RequestBody Long userId){
        userService.banUser(userId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/users")
    public ResponseEntity<?> unbanUser(@RequestBody Long userId){
        userService.unbanUser(userId);
        return ResponseEntity.ok().build();
    }
}
