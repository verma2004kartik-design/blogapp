package blogapp.repository;

import blogapp.entity.PostEntityDay5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryDay5
        extends JpaRepository<PostEntityDay5, Long> {
}