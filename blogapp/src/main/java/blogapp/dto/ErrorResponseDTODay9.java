package blogapp.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTODay9 {

    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorResponseDTODay9() {
    }

    public ErrorResponseDTODay9(
            LocalDateTime timestamp,
            String message,
            String details) {

        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}