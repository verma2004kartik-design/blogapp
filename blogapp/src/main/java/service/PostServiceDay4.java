package blogapp.service;

import blogapp.entity.PostEntityDay4;
import blogapp.repository.PostRepositoryDay4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PostServiceDay4 {

    @Autowired
    private PostRepositoryDay4 postRepositoryDay4;

    public PostEntityDay4 savePost(PostEntityDay4 post) {
        return postRepositoryDay4.save(post);
    }

    public List<PostEntityDay4> getAllPosts() {
        return postRepositoryDay4.findAll();
    }

    public PostEntityDay4 getPostById(Long id) {
        return postRepositoryDay4.findById(id).orElse(null);
    }

    public PostEntityDay4 updatePost(Long id, PostEntityDay4 updatedPost) {

        return postRepositoryDay4.findById(id).map(post -> {

            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            post.setUserId(updatedPost.getUserId());
            post.setUpdatedAt(LocalDateTime.now());

            return postRepositoryDay4.save(post);

        }).orElse(null);
    }

    public boolean deletePost(Long id) {
        if (postRepositoryDay4.existsById(id)) {
            postRepositoryDay4.deleteById(id);
            return true;
        }
        return false;
    }
}