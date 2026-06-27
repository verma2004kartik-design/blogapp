package blogapp.repository;

import blogapp.entity.UserEntityDay5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDay5
        extends JpaRepository<UserEntityDay5, Long> {
}