package blogapp.repository;

import blogapp.entity.PostEntityDay4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryDay4 extends JpaRepository<PostEntityDay4, Long> {

}