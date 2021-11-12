package com.ironhack.searchservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Repository.MovieTitleSearchResultRepository;
import com.ironhack.searchservice.Utils.UncheckedObjectMapper;
import com.ironhack.searchservice.dao.MovieTitleIdSearchResult;
import com.ironhack.searchservice.dao.MovieTitleSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class MovieSearchService {

    @Autowired
    MovieTitleSearchResultRepository movieTitleSearchResultRepository;

    private final String baseURL = "https://imdb-api.com/en/API/";
    private final String apiKey = "/k_nqs3pkmh/";
    private HttpClient client = HttpClient.newHttpClient();

    public String searchByTitle(String title) throws ExecutionException, InterruptedException, JsonProcessingException {

        var request = HttpRequest.newBuilder(
                URI.create(baseURL + "SearchMovie" + apiKey + title))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        List<MovieTitleSearchResult> movieTitleSearchResultList = new ArrayList<>();

        for (JsonNode movieObj : responseNodeTree.get("results")) {
            movieTitleSearchResultList.add(new MovieTitleSearchResult(movieObj));
        }

        movieTitleSearchResultRepository.saveAll(movieTitleSearchResultList);

        return movieTitleSearchResultList.size() + " movies found";

    }

    public String searchByTitleId(String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
        var request = HttpRequest.newBuilder(
                URI.create(baseURL + "Title" + apiKey + id))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        MovieTitleIdSearchResult movieObj = new MovieTitleIdSearchResult(responseNodeTree);

        return movieObj.toString();

    }
}
