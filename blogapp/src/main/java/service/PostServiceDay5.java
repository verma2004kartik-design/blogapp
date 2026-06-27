package blogapp.service;

import blogapp.entity.PostEntityDay5;
import blogapp.repository.PostRepositoryDay5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceDay5 {

    @Autowired
    private PostRepositoryDay5 postRepositoryDay5;

    public PostEntityDay5 savePost(PostEntityDay5 post) {
        return postRepositoryDay5.save(post);
    }

    public List<PostEntityDay5> getAllPosts() {
        return postRepositoryDay5.findAll();
    }

    public PostEntityDay5 getPostById(Long id) {
        return postRepositoryDay5.findById(id).orElse(null);
    }
}