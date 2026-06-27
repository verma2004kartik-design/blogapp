package blogapp.service;

import blogapp.entity.CommentEntityDay5;
import blogapp.repository.CommentRepositoryDay5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceDay5 {

    @Autowired
    private CommentRepositoryDay5 commentRepositoryDay5;

    public CommentEntityDay5 saveComment(CommentEntityDay5 comment) {
        return commentRepositoryDay5.save(comment);
    }

    public List<CommentEntityDay5> getAllComments() {
        return commentRepositoryDay5.findAll();
    }

    public CommentEntityDay5 getCommentById(Long id) {
        return commentRepositoryDay5.findById(id).orElse(null);
    }
}