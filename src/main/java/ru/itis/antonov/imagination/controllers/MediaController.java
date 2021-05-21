package ru.itis.antonov.imagination.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.antonov.imagination.exception.ImageFileNotFoundException;
import ru.itis.antonov.imagination.services.implementations.FileMediaService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class MediaController {
    private FileMediaService service;

    public MediaController(FileMediaService service) {
        this.service = service;
    }

    @GetMapping("/media/{name}")
    public void getImage(@PathVariable String name, OutputStream out){
        InputStream in = service.getImage(name);
        byte[] buffer = new byte[1024];
        try {
            while (in.read(buffer) != -1){
                out.write(buffer);
            }
            in.close();
            out.close();
        } catch (IOException e){
            throw new ImageFileNotFoundException(e);
        }
    }
}
