package blogapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users_day5")
public class UserEntityDay5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    // One User -> Many Posts
    @JsonManagedReference("user-post")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostEntityDay5> posts;

    // One User -> Many Comments
    @JsonManagedReference("user-comment")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CommentEntityDay5> comments;

    public UserEntityDay5() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PostEntityDay5> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntityDay5> posts) {
        this.posts = posts;
    }

    public List<CommentEntityDay5> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntityDay5> comments) {
        this.comments = comments;
    }
}