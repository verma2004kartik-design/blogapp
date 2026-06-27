package blogapp.controller;

import blogapp.entity.PostEntityDay8;
import blogapp.service.PostServiceDay8;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day8/posts")
public class PostControllerDay8 {

    @Autowired
    private PostServiceDay8 service;

    // Create Post
    @PostMapping
    public PostEntityDay8 createPost(
            @Valid
            @RequestBody PostEntityDay8 post) {

        return service.savePost(post);
    }
}