package com.cs348pj.restapi.util;

import com.cs348pj.restapi.constants.RestApiConstants;
import com.cs348pj.restapi.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class DataLoader {
    private final HttpClient client;

    public DataLoader() {
        client = HttpClient.newHttpClient();
    }

    // returns null on error
    public Course getCourseById(String termCode, String courseId) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpResponse<String> response = sendRequest(termCode, courseId);

            return mapper.readValue(response.body(), Course.class);
        } catch(Exception e) {
            System.err.println("Error creating the DataLoader");
        }

        return null;
    }

    public List<Course> getCoursesBySubject(String termCode, String subjectCode) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HttpResponse<String> response = sendRequest(termCode, subjectCode);

            return mapper.readValue(response.body(),
                    mapper.getTypeFactory().constructCollectionType(List.class, Course.class));
        } catch(Exception e) {
            System.err.println("Error creating the DataLoader");
        }
        return null;
    }

    private HttpResponse<String> sendRequest(String firstParam, String secondParam) throws Exception {
        String uriStr = String.format(RestApiConstants.UW_OPEN_API_URI + "/Courses/%s/%s",
                firstParam, secondParam);
        URI uri = new URI(uriStr);

        HttpRequest request = HttpRequest.newBuilder(uri)
                .headers("Accept", "application/json",
                        "x-api-key", RestApiConstants.UW_API_KEY)
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

}
