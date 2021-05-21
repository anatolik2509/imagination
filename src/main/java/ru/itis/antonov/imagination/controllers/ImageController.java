package ru.itis.antonov.imagination.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.ImageService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image/{id}")
    public String getView(@PathVariable Long id, @AuthenticationPrincipal UserDetailsModelImpl userDetails, Model model){
        model.addAttribute("image", imageService.getImageById(id, userDetails.getUser().getId()));
        return "imageView";
    }

    @DeleteMapping("/image/delete/{id}")
    public void delete(@PathVariable Long id, @AuthenticationPrincipal UserDetailsModelImpl userDetails, HttpServletResponse response){
        imageService.delete(id, userDetails.getUser().getId());
        response.setStatus(200);

    }
}
