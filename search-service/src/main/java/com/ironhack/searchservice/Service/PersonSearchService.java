package com.ironhack.searchservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.dao.PersonIdResult;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import com.ironhack.searchservice.Utils.UncheckedObjectMapper;

@Service
public class PersonSearchService {


    private final String baseURL = "https://imdb-api.com/en/API/";
    private final String apiKey = "/k_nqs3pkmh/";
    private HttpClient client = HttpClient.newHttpClient();

    public String searchByNameId(String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {

        var request = HttpRequest.newBuilder(
                URI.create(baseURL + "Name" + apiKey + id))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        PersonIdResult person = new PersonIdResult(responseNodeTree);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

    }

    public String searchByName(String name) throws ExecutionException, InterruptedException, JsonProcessingException {

        var request = HttpRequest.newBuilder(
                URI.create(baseURL + "SearchName" + apiKey + name.replace(" ", "%20")))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        List<NameSearchResult> nameSearchResultList = new ArrayList<>();

        for (JsonNode personObj : responseNodeTree.get("results")) {
            nameSearchResultList.add(new NameSearchResult(personObj));
        }

        return nameSearchResultList.toString();
    }
}
