package blogapp.controller;

import blogapp.entity.PostEntityDay7;
import blogapp.service.PostServiceDay7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day7/posts")
public class PostControllerDay7 {

    @Autowired
    private PostServiceDay7 service;

    // Create Post
    @PostMapping
    public PostEntityDay7 createPost(
            @RequestBody PostEntityDay7 post) {

        return service.savePost(post);
    }

    // Pagination
    @GetMapping
    public Page<PostEntityDay7> getPosts(

            @RequestParam int page,

            @RequestParam int size) {

        return service.getPosts(page, size);
    }

    // Pagination + Sorting
    @GetMapping("/sorted")
    public Page<PostEntityDay7> getSortedPosts(

            @RequestParam int page,

            @RequestParam int size,

            @RequestParam String sort,

            @RequestParam String direction) {

        return service.getPostsSorted(
                page,
                size,
                sort,
                direction);
    }

    // Sort Title A-Z
    @GetMapping("/title-sort")
    public Page<PostEntityDay7> titleSort(

            @RequestParam int page,

            @RequestParam int size) {

        return service.sortTitleAZ(
                page,
                size);
    }
}