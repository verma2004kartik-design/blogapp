package blogapp.repository;

import blogapp.entity.CommentEntityDay5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositoryDay5
        extends JpaRepository<CommentEntityDay5, Long> {
}