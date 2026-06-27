package blogapp.repository;

import blogapp.entity.UserEntityDay14;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryDay14
        extends JpaRepository<UserEntityDay14, Long> {

    Optional<UserEntityDay14> findByUsername(String username);

    boolean existsByEmail(String email);
}