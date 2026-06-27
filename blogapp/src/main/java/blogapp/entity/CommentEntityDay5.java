package blogapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "comments_day5")
public class CommentEntityDay5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    // Many Comments -> One Post
    @JsonBackReference("post-comment")
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntityDay5 post;

    // Many Comments -> One User
    @JsonBackReference("user-comment")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntityDay5 user;

    public CommentEntityDay5() {
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostEntityDay5 getPost() {
        return post;
    }

    public void setPost(PostEntityDay5 post) {
        this.post = post;
    }

    public UserEntityDay5 getUser() {
        return user;
    }

    public void setUser(UserEntityDay5 user) {
        this.user = user;
    }
}