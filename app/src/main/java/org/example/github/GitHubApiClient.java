package org.example.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GitHubApiClient {

    private static final String BASE_URL = "https://api.github.com";

    public ApiResponse getUserRepos(String username) throws IOException {
        String endpoint = BASE_URL + "/users/" + username + "/repos";
        URL url = new URL(endpoint);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("User-Agent", "QA-Automation-Test");

        int statusCode = connection.getResponseCode();

        InputStream stream;
        if (statusCode >= 200 && statusCode < 400) {
            System.out.println("Statuse Code: " + statusCode);
            stream = connection.getInputStream();
        } else {
            stream = connection.getErrorStream();
        }

        String responseBody = readStream(stream);
        connection.disconnect();

        return new ApiResponse(statusCode, responseBody);
    }

    private String readStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }
}
