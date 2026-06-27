package blogapp.repository;

import blogapp.entity.UserEntityDay10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDay10
        extends JpaRepository<UserEntityDay10, Long> {
}