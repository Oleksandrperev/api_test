package org.example.github;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jdi.request.StepRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GitHubApiTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getUserRepos_forExistingUser_returns200() throws Exception {
        GitHubApiClient client = new GitHubApiClient();

        ApiResponse response = client.getUserRepos("oleksandrperev");

        assertEquals(200, response.getStatusCode(), "Status code should be 200 for existing user");
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty(), "Response body should not be empty");

        JsonNode root = objectMapper.readTree(response.getBody());
        assertTrue(root.isArray(), "Root should be a JSON array");

        JsonNode firstRepo = root.get(0);
        System.out.println("First repo data: " + firstRepo.toString());
        String repoName = firstRepo.get("name").asText();
        System.out.println("NAME: " + repoName);
        assertEquals("api_test", repoName, "Validation FAILED! Actual value: " + repoName);
        System.out.println("Validation SUCCEED!!!");
    }
}
