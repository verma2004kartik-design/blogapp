package blogapp.controller;

import blogapp.entity.CommentEntityDay5;
import blogapp.service.CommentServiceDay5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day5/comments")
public class CommentControllerDay5 {

    @Autowired
    private CommentServiceDay5 commentServiceDay5;

    // CREATE COMMENT
    @PostMapping
    public CommentEntityDay5 createComment(
            @RequestBody CommentEntityDay5 comment) {

        return commentServiceDay5.saveComment(comment);
    }

    // GET ALL COMMENTS
    @GetMapping
    public List<CommentEntityDay5> getAllComments() {
        return commentServiceDay5.getAllComments();
    }

    // GET COMMENT BY ID
    @GetMapping("/{id}")
    public CommentEntityDay5 getCommentById(
            @PathVariable Long id) {

        return commentServiceDay5.getCommentById(id);
    }
}