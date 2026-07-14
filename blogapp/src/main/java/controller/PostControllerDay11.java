package blogapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day11/posts")
public class PostControllerDay11 {

    @GetMapping
    public String getPosts() {

        return "Public Posts Endpoint";
    }

    @GetMapping("/secure")
    public String securePosts() {

        return "Authenticated User Access";
    }

    @GetMapping("/admin")
    public String adminPosts() {

        return "Admin Access Only";
    }
}