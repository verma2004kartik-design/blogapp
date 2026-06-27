package blogapp.service;

import blogapp.entity.PostEntityDay7;
import blogapp.repository.PostRepositoryDay7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.stereotype.Service;

@Service
public class PostServiceDay7 {

    @Autowired
    private PostRepositoryDay7 repository;

    // Create Post
    public PostEntityDay7 savePost(
            PostEntityDay7 post) {

        return repository.save(post);
    }

    // Pagination Only
    public Page<PostEntityDay7> getPosts(
            int page,
            int size) {

        Pageable pageable =
                PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    // Pagination + Sorting
    public Page<PostEntityDay7> getPostsSorted(
            int page,
            int size,
            String sortField,
            String direction) {

        Sort sort =
                direction.equalsIgnoreCase("desc")
                        ? Sort.by(sortField).descending()
                        : Sort.by(sortField).ascending();

        Pageable pageable =
                PageRequest.of(page, size, sort);

        return repository.findAll(pageable);
    }

    // Title A-Z
    public Page<PostEntityDay7> sortTitleAZ(
            int page,
            int size) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by("title").ascending()
                );

        return repository.findAll(pageable);
    }
}