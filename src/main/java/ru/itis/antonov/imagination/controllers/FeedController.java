package ru.itis.antonov.imagination.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.ImageService;

@Controller
public class FeedController {
    private ImageService imageService;

    public FeedController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/feed")
    public String getFeedView(){
        return "feed";
    }

    @GetMapping(value = "/feed", params = {"limit", "offset"})
    public String getFeedView(@AuthenticationPrincipal UserDetailsModelImpl userDetails,
                              @RequestParam int limit,
                              @RequestParam int offset,
                              Model model){
        model.addAttribute("images", imageService.getFeed(userDetails.getUser().getId(), limit, offset));
        return "imageList";
    }

    @GetMapping("/thread/{id}")
    public String thread(Model model, @PathVariable Long id){
        model.addAttribute("images", imageService.getThread(id));
        return "albumView";
    }

}
