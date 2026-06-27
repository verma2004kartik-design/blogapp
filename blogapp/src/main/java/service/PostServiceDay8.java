package blogapp.service;

import blogapp.entity.PostEntityDay8;
import blogapp.repository.PostRepositoryDay8;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceDay8 {

    @Autowired
    private PostRepositoryDay8 repository;

    public PostEntityDay8 savePost(
            PostEntityDay8 post) {

        return repository.save(post);
    }
}