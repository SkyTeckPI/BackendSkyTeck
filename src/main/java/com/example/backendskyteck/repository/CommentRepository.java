package com.example.backendskyteck.repository;

import com.example.backendskyteck.entities.Comment;
import com.example.backendskyteck.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPoste (Poste poste);

    //findbyUser and post
}
