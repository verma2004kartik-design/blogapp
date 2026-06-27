package blogapp.repository;

import blogapp.entity.PostEntityDay6;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PostRepositoryDay6
        extends JpaRepository<PostEntityDay6, Long> {

    // JPQL Query
    @Query("SELECT p FROM PostEntityDay6 p")
    List<PostEntityDay6> getAllPosts();

    // Search by keyword
    @Query("""
            SELECT p
            FROM PostEntityDay6 p
            WHERE LOWER(p.title)
            LIKE LOWER(CONCAT('%',:keyword,'%'))
            """)
    List<PostEntityDay6> searchPosts(
            @Param("keyword") String keyword);

    // Last 7 Days Posts
    @Query("""
            SELECT p
            FROM PostEntityDay6 p
            WHERE p.createdDate >= :date
            """)
    List<PostEntityDay6> findRecentPosts(
            @Param("date") LocalDate date);

    // Native SQL Query
    @Query(
            value = "SELECT * FROM posts_day6",
            nativeQuery = true
    )
    List<PostEntityDay6> getAllPostsNative();

    Page<PostEntityDay6> findAll(Pageable pageable);
}