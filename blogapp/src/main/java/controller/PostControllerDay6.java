package blogapp.controller;

import blogapp.entity.PostEntityDay6;
import blogapp.service.PostServiceDay6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day6/posts")
public class PostControllerDay6 {

    @Autowired
    private PostServiceDay6 service;

    // Create Post
    @PostMapping
    public PostEntityDay6 createPost(
            @RequestBody PostEntityDay6 post) {

        return service.savePost(post);
    }

    // Get All Posts
    @GetMapping("/all")
    public List<PostEntityDay6> getAllPosts() {

        return service.getAllPosts();
    }

    // Search By Keyword
    @GetMapping("/search")
    public List<PostEntityDay6> searchPosts(
            @RequestParam String keyword) {

        return service.searchPosts(keyword);
    }

    // Recent Posts
    @GetMapping("/recent")
    public List<PostEntityDay6> recentPosts() {

        return service.getRecentPosts();
    }

    // Native Query
    @GetMapping("/native")
    public List<PostEntityDay6> nativePosts() {

        return service.getAllPostsNative();
    }

    // Pagination
    @GetMapping("/page")
    public Page<PostEntityDay6> getPosts(

            @RequestParam int page,
            @RequestParam int size) {

        return service.getPosts(page, size);
    }
}