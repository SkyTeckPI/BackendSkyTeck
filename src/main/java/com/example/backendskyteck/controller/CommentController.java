package com.example.backendskyteck.controller;


import com.example.backendskyteck.entities.Comment;
import com.example.backendskyteck.serviceInterface.IcommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Comment management " )
@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    IcommentService IcommentService ;

    @PostMapping ("/add/{posteId}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable("posteId") Long postId) {
        return IcommentService.addComment(comment, postId);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment comment) {
        return IcommentService.updateComment(comment);
    }

    @GetMapping("/all")
    public List<Comment> comments() {
        return IcommentService.comments();
    }
    @DeleteMapping("/delete/{commentId}")

    public void removeComment( @PathVariable("commentId") Long commentId) {
        IcommentService.removeComment(commentId);
    }
}
