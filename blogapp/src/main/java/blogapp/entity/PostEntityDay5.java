package blogapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts_day5")
public class PostEntityDay5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    // Many Posts -> One User
    @JsonBackReference("user-post")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntityDay5 user;

    // One Post -> Many Comments
    @JsonManagedReference("post-comment")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<CommentEntityDay5> comments;

    public PostEntityDay5() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntityDay5 getUser() {
        return user;
    }

    public void setUser(UserEntityDay5 user) {
        this.user = user;
    }

    public List<CommentEntityDay5> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntityDay5> comments) {
        this.comments = comments;
    }
}