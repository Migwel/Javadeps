package dev.migwel.javadeps.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.migwel.javadeps.data.AdepsResponse;
import dev.migwel.javadeps.exception.FetchException;
import dev.migwel.javadeps.filters.Filter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class AdepsCaller {

    private static final Logger log = LoggerFactory.getLogger(AdepsCaller.class);

    private final static String ADEPS_URL = "https://www.odwb.be/api/records/1.0/search/?dataset=points-verts-de-ladeps&q=";
    private final HttpClient httpClient;
    private final Filter filter;
    private final ObjectMapper objectMapper;

    public AdepsCaller(Filter filter, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.filter = filter;
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public AdepsCaller(Filter filter, HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.filter = filter;
        this.objectMapper = objectMapper;
    }

    public AdepsResponse call() {
        HttpRequest httpRequest = buildRequest();
        HttpResponse<String> httpResponse;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.warn("Could not send request", e);
            throw new FetchException("Could not send request", e);
        }
        if (httpResponse.statusCode() != 200) {
            log.warn("Did not get a 200 but instead a "+ httpResponse.statusCode());
            throw new FetchException("Received a "+ httpResponse.statusCode() +" status code");
        }
        if (httpResponse.body() == null || httpResponse.body().isEmpty()) {
            throw new FetchException("Received an empty response");
        }
        return buildResponse(httpResponse.body());
    }

    private AdepsResponse buildResponse(@NotNull String responseStr) {
        try {
            return objectMapper.readValue(responseStr, AdepsResponse.class);
        } catch (JsonProcessingException e) {
            log.warn("Could not deserialize the response: "+ responseStr, e);
            throw new FetchException("Could not deserialize the response: "+ responseStr, e);
        }
    }

    private HttpRequest buildRequest() {
        return HttpRequest.newBuilder()
                .uri(URI.create(ADEPS_URL + URLEncoder.encode(filter.getQuery(), StandardCharsets.UTF_8)))
                .GET()
                .build();
    }
}
