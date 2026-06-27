package blogapp.dto;

import jakarta.validation.constraints.*;

public class UserRegistrationDTO {

    @NotBlank
    private String username;

    @Email
    private String email;

    @Pattern(
            regexp = "^(?=.*\\d).{8,}$",
            message =
                    "Password must be at least 8 characters and contain a number"
    )
    private String password;

    public UserRegistrationDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}