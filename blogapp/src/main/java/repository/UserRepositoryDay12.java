package blogapp.repository;

import blogapp.entity.UserEntityDay12;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryDay12
        extends JpaRepository<UserEntityDay12, Long> {

    Optional<UserEntityDay12>
    findByUsername(String username);

    boolean existsByEmail(String email);
}