package ru.itis.antonov.imagination.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.antonov.imagination.dto.form.CommentForm;
import ru.itis.antonov.imagination.security.details.UserDetailsModelImpl;
import ru.itis.antonov.imagination.services.interfaces.CommentService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/add")
    public String addComment(@RequestParam Long imageId,
                             CommentForm commentForm,
                             @AuthenticationPrincipal UserDetailsModelImpl userDetails) {
        commentService.addComment(commentForm, userDetails.getUser().getId(), imageId);
        return "redirect:/image/" + imageId;
    }
}
