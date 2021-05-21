package ru.itis.antonov.imagination.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.antonov.imagination.dto.ImageDto;
import ru.itis.antonov.imagination.dto.form.ImageForm;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.ImageService;
import ru.itis.antonov.imagination.services.interfaces.MediaService;

@Controller
public class ImageUploadController {

    private ImageService imageService;

    public ImageUploadController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image/upload")
    public String getUploadView(Model model){
        model.addAttribute("parentId", -1);
        return "imageUpload";
    }

    @GetMapping("/image/upload/{id}")
    public String getUploadView(Model model,@PathVariable Long id){
        model.addAttribute("parentId", id);
        return "imageUpload";
    }

    @PostMapping("/image/upload")
    public String uploadImage(MultipartFile file, @RequestParam Long parentId, @AuthenticationPrincipal UserDetailsModelImpl userDetails){
        ImageDto imageDto = imageService.saveImage(new ImageForm(file, parentId), userDetails.getUser().getId());
        return "redirect:/image/" + imageDto.getId();
    }

    @GetMapping("/image/replace/{id}")
    public String getReplaceView(Model model,@PathVariable Long id){
        model.addAttribute("imageId", id);
        return "imageReplace";
    }

    @PostMapping("/image/replace/{id}")
    public String replace(MultipartFile file, @AuthenticationPrincipal UserDetailsModelImpl userDetails, @PathVariable Long id){
        imageService.update(id, new ImageForm(file, -1L), userDetails.getUser().getId());
        return "redirect:/image/" + id;
    }
}
