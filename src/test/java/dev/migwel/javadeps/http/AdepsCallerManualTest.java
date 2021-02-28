package dev.migwel.javadeps.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.migwel.javadeps.Province;
import dev.migwel.javadeps.filters.Filter;
import dev.migwel.javadeps.filters.ProvinceFilter;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;

class AdepsCallerManualTest {

    private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getValidResults() {
        Filter filter = new ProvinceFilter(Province.LIEGE);
        AdepsCaller adepsCaller = new AdepsCaller(filter, httpClient, objectMapper);
        System.out.println(adepsCaller.call());
    }

}