package blogapp.service;

import blogapp.entity.PostEntityDay6;
import blogapp.repository.PostRepositoryDay6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostServiceDay6 {

    @Autowired
    private PostRepositoryDay6 repository;

    public PostEntityDay6 savePost(
            PostEntityDay6 post) {

        return repository.save(post);
    }

    public List<PostEntityDay6> getAllPosts() {
        return repository.getAllPosts();
    }

    public List<PostEntityDay6> searchPosts(
            String keyword) {

        return repository.searchPosts(keyword);
    }

    public List<PostEntityDay6> getRecentPosts() {

        LocalDate sevenDaysAgo =
                LocalDate.now().minusDays(7);

        return repository
                .findRecentPosts(sevenDaysAgo);
    }

    public List<PostEntityDay6> getAllPostsNative() {

        return repository.getAllPostsNative();
    }

    public Page<PostEntityDay6> getPosts(
            int page,
            int size) {

        Pageable pageable =
                PageRequest.of(page, size);

        return repository.findAll(pageable);
    }
}