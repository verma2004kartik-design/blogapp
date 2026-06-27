package blogapp.controller;

import blogapp.service.PostServiceDay9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day9/posts")
public class PostControllerDay9 {

    @Autowired
    private PostServiceDay9 service;

    @GetMapping("/{id}")
    public String getPost(@PathVariable Long id) {
        return service.findPost(id);
    }

    @PostMapping
    public String createPost(@RequestParam String title) {
        return service.createPost(title);
    }
}