package ru.itis.antonov.imagination.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.antonov.imagination.dto.AlbumDto;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.AlbumService;

@Controller
public class AlbumController {
    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/album/{id}")
    public String getAlbumView(Model model, @PathVariable Long id){
        model.addAttribute("images", albumService.getAlbumById(id).getImages());
        return "albumView";
    }

    @PostMapping("/album/create")
    public String createAlbum(@AuthenticationPrincipal UserDetailsModelImpl userDetails, @RequestParam String albumName){
        AlbumDto albumDto = albumService.createAlbum(userDetails.getUser().getId(), albumName);
        return "redirect:/album/" + albumDto.getId();
    }

    @PostMapping("/album/add")
    public String createAlbum(@AuthenticationPrincipal UserDetailsModelImpl userDetails, @RequestParam Long albumId, @RequestParam Long imageId){
        albumService.addImageToAlbum(imageId, albumId);
        return "redirect:/album/" + albumId;
    }
}
