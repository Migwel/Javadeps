package dev.migwel.javadeps.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.migwel.javadeps.Province;
import dev.migwel.javadeps.data.AdepsEntry;
import dev.migwel.javadeps.data.AdepsResponse;
import dev.migwel.javadeps.data.Status;
import dev.migwel.javadeps.filters.Filter;
import dev.migwel.javadeps.filters.ProvinceFilter;
import dev.migwel.javadeps.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AdepsCallerTest {

    private final HttpClient httpClient = mock(HttpClient.class);


    @BeforeEach
    void before() throws IOException, InterruptedException, URISyntaxException {
        String validJson = FileUtil.loadFile("valid.json");
        HttpResponse<String> validResponse = buildMockHttpResponse(validJson, 200);
        when(httpClient.send(any(), eq(HttpResponse.BodyHandlers.ofString()))).thenReturn(validResponse);
    }

    private HttpResponse<String> buildMockHttpResponse(String json, int statusCode) {
        @SuppressWarnings("unchecked")
        HttpResponse<String> response = mock(HttpResponse.class);
        when(response.statusCode()).thenReturn(statusCode);
        when(response.body()).thenReturn(json);
        return response;
    }

    @Test
    void getValidEntry() {
        Filter filter = new ProvinceFilter(Province.LIEGE);
        AdepsCaller adepsCaller = new AdepsCaller(filter, httpClient);
        AdepsResponse response = adepsCaller.call();
        assertEquals(10, response.entries().size());
        AdepsEntry entry = response.entries().stream().filter(e -> e.id().equals("0f4fafe6d3ab553cb7cede49f6414cfa95b56e4c")).findFirst().orElseThrow();
        assertTrue(entry.fields().bike());
        assertEquals("L048", entry.fields().ndegPv());
        assertEquals(Status.OK, entry.fields().status());
        assertEquals(LocalDate.of(2021, 6, 27), entry.fields().date());
    }

    @Test
    void getCancelledEntry() {
        Filter filter = new ProvinceFilter(Province.LIEGE);
        AdepsCaller adepsCaller = new AdepsCaller(filter, httpClient);
        AdepsResponse response = adepsCaller.call();
        AdepsEntry entry = response.entries().stream().filter(e -> e.id().equals("4766f17d820819530296c24c7ba79a7688a29395")).findFirst().orElseThrow();
        assertEquals(Status.CANCELLED, entry.fields().status());
    }
}