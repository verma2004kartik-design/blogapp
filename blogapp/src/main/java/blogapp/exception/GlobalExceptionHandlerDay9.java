package blogapp.exception;

import blogapp.dto.ErrorResponseDTODay9;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandlerDay9 {

    @ExceptionHandler(
            ResourceNotFoundExceptionDay9.class)
    public ResponseEntity<ErrorResponseDTODay9>
    handleResourceNotFound(
            ResourceNotFoundExceptionDay9 ex) {

        ErrorResponseDTODay9 error =
                new ErrorResponseDTODay9(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        "Requested resource does not exist"
                );

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(
            BadRequestExceptionDay9.class)
    public ResponseEntity<ErrorResponseDTODay9>
    handleBadRequest(
            BadRequestExceptionDay9 ex) {

        ErrorResponseDTODay9 error =
                new ErrorResponseDTODay9(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        "Invalid request"
                );

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(
            DuplicateResourceExceptionDay9.class)
    public ResponseEntity<ErrorResponseDTODay9>
    handleDuplicateResource(
            DuplicateResourceExceptionDay9 ex) {

        ErrorResponseDTODay9 error =
                new ErrorResponseDTODay9(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        "Duplicate resource"
                );

        return new ResponseEntity<>(
                error,
                HttpStatus.CONFLICT
        );
    }
}