package com.example.backendskyteck.serviceImplimentation;

import com.example.backendskyteck.entities.Comment;
import com.example.backendskyteck.entities.Poste;
import com.example.backendskyteck.repository.CommentRepository;
import com.example.backendskyteck.repository.PosteRepository;
import com.example.backendskyteck.serviceInterface.IcommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImp implements IcommentService {
    CommentRepository commentRepository ;
    PosteRepository posteRepository ;
    @Override
    public Comment addComment(Comment comment, Long postId) {
        Poste poste =  posteRepository.findById(postId).orElse(null);
        if ( poste !=null){
            comment.setPoste(poste);
            poste.getComments().add(comment);
           return commentRepository.save(comment);

        }
        else  throw  new RuntimeException (" no existancetance of poste "+postId);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> comments() {
        return commentRepository.findAll();
    }

    @Override
    public void removeComment(Long commentId) {
        this.commentRepository.deleteById(commentId);

    }
}
