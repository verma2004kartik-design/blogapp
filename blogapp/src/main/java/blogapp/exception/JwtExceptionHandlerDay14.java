package blogapp.exception;

import io.jsonwebtoken.JwtException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JwtExceptionHandlerDay14 {

    @ExceptionHandler(JwtException.class)

    public ResponseEntity<String> handleJwtException(

            JwtException ex) {

        return new ResponseEntity<>(

                "Invalid or Expired JWT Token",

                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)

    public ResponseEntity<String> handleException(

            Exception ex) {

        return new ResponseEntity<>(

                ex.getMessage(),

                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}