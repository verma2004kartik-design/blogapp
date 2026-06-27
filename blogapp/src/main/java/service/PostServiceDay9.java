package blogapp.service;

import blogapp.exception.BadRequestExceptionDay9;
import blogapp.exception.DuplicateResourceExceptionDay9;
import blogapp.exception.ResourceNotFoundExceptionDay9;

import org.springframework.stereotype.Service;

@Service
public class PostServiceDay9 {

    public String findPost(Long id) {

        if (id != 1) {

            throw new ResourceNotFoundExceptionDay9(
                    "Post not found with ID " + id);
        }

        return "Post Found Successfully";
    }

    public String createPost(String title) {

        if (title == null || title.isBlank()) {

            throw new BadRequestExceptionDay9(
                    "Title cannot be empty");
        }

        if (title.equalsIgnoreCase("Spring")) {

            throw new DuplicateResourceExceptionDay9(
                    "Post already exists");
        }

        return "Post Created Successfully";
    }
}