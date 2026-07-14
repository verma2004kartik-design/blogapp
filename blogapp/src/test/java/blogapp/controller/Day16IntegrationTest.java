package blogapp.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

@AutoConfigureMockMvc

@TestPropertySource(
        locations = "classpath:applicationDay16.properties"
)

@Sql(statements = {

        "DELETE FROM users_day14"

})

public class Day16IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // =====================================
    // TEST 1 : Create Post
    // =====================================

    @Test
    void createPostTest() throws Exception {

        mockMvc.perform(

                        post("/day9/posts")

                                .param(
                                        "title",
                                        "Spring Boot Day16")

                )

                .andExpect(status().isOk());

    }

    // =====================================
    // TEST 2 : Get Post
    // =====================================

    @Test
    void getPostTest() throws Exception {

        mockMvc.perform(

                        get("/day9/posts/1")

                )

                .andExpect(status().isOk());

    }

    // =====================================
    // TEST 3 : Login API
    // =====================================

    @Test
    void loginTest() throws Exception {

        String json = """
                {
                  "username":"admin",
                  "password":"admin"
                }
                """;

        mockMvc.perform(

                        post("/day14/auth/login")

                                .contentType(
                                        MediaType.APPLICATION_JSON)

                                .content(json)

                )

                .andExpect(status().isOk());

    }

    // =====================================
    // TEST 4 : Protected Endpoint
    // =====================================

    @Test
    void currentUserTest() throws Exception {

        mockMvc.perform(

                        get("/day14/auth/me")

                                .header(
                                        "Authorization",
                                        "Bearer dummy-token")

                )

                .andExpect(status().isUnauthorized());

    }

    // =====================================
    // TEST 5 : Invalid Login
    // =====================================

    @Test
    void invalidLoginTest() throws Exception {

        String json = """
                {
                  "username":"wrong",
                  "password":"wrong"
                }
                """;

        mockMvc.perform(

                        post("/day14/auth/login")

                                .contentType(
                                        MediaType.APPLICATION_JSON)

                                .content(json)

                )

                .andExpect(status().is4xxClientError());

    }

}