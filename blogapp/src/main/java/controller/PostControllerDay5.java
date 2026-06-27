package blogapp.controller;

import blogapp.entity.PostEntityDay5;
import blogapp.service.PostServiceDay5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day5/posts")
public class PostControllerDay5 {

    @Autowired
    private PostServiceDay5 postServiceDay5;

    // CREATE POST
    @PostMapping
    public PostEntityDay5 createPost(@RequestBody PostEntityDay5 post) {
        return postServiceDay5.savePost(post);
    }

    // GET ALL POSTS
    @GetMapping
    public List<PostEntityDay5> getAllPosts() {
        return postServiceDay5.getAllPosts();
    }

    // GET POST BY ID
    @GetMapping("/{id}")
    public PostEntityDay5 getPostById(@PathVariable Long id) {
        return postServiceDay5.getPostById(id);
    }
}