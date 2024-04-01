package com.example.backendskyteck.serviceInterface;

import com.example.backendskyteck.entities.Comment;

import java.util.List;

public interface IcommentService {

    Comment addComment(Comment comment, Long postId); // Creating a comment and adding it to a post

    Comment updateComment(Comment comment); // Update a comment within a post

    List<Comment> comments(); // Retrieve all comments

    void removeComment(Long commentId); // Remove a comment

}
