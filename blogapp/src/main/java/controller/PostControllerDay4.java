package blogapp.controller;

import blogapp.entity.PostEntityDay4;
import blogapp.service.PostServiceDay4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day4/posts")
public class PostControllerDay4 {

    @Autowired
    private PostServiceDay4 postServiceDay4;

    // TEST
    @PostMapping("/test")
    public String test(@RequestBody String body) {
        return "Received: " + body;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<PostEntityDay4> createPost(@RequestBody PostEntityDay4 post) {
        return ResponseEntity.ok(postServiceDay4.savePost(post));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<PostEntityDay4>> getAllPosts() {
        return ResponseEntity.ok(postServiceDay4.getAllPosts());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PostEntityDay4> getPostById(@PathVariable Long id) {
        PostEntityDay4 post = postServiceDay4.getPostById(id);
        return post != null ? ResponseEntity.ok(post)
                : ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PostEntityDay4> updatePost(
            @PathVariable Long id,
            @RequestBody PostEntityDay4 updatedPost) {

        PostEntityDay4 post = postServiceDay4.updatePost(id, updatedPost);

        return post != null ? ResponseEntity.ok(post)
                : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {

        boolean deleted = postServiceDay4.deletePost(id);

        return deleted ? ResponseEntity.ok("Deleted successfully")
                : ResponseEntity.notFound().build();
    }
}