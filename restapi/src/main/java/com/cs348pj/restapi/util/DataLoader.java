package com.cs348pj.restapi.util;

import com.cs348pj.restapi.constants.RestApiConstants;
import com.cs348pj.restapi.dto.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataLoader {
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public DataLoader() {
        client = HttpClient.newHttpClient();
    }

    // returns null on error
    public Course getCourseById(String termCode, String courseId) {
        try {
            String uriStr = String.format(RestApiConstants.UW_OPEN_API_URI + "/Courses/%s/%s",
                    termCode, courseId);
            URI uri = new URI(uriStr);
            ObjectMapper mapper = new ObjectMapper();

                    request = HttpRequest.newBuilder(uri)
                    .headers("Accept", "application/json",
                             "connection", "keep-alive",
                             "x-api-key", RestApiConstants.UW_API_KEY)
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return mapper.readValue(response.body(), Course.class);
        } catch(Exception e) {
            System.err.println("Error creating the DataLoader");
        }

        return null;
    }

}
