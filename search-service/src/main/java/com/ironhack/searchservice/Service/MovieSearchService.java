package com.ironhack.searchservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Repository.TitleSearchResultRepository;
import com.ironhack.searchservice.Utils.UncheckedObjectMapper;
import com.ironhack.searchservice.dao.TitleIdResult;
import com.ironhack.searchservice.dao.TitleSearchResult;
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
    TitleSearchResultRepository titleSearchResultRepository;

    private final String baseURL = "https://imdb-api.com/en/API/";
    private final String apiKey = "/pk_cxhl31gu5d4vsbox5/";
    private HttpClient client = HttpClient.newHttpClient();

    public String searchByMovieTitle(String type, String title) throws ExecutionException, InterruptedException, JsonProcessingException {

        String searchType = type.equals("movie") ? "SearchMovie" : "SearchSeries";

        var request = HttpRequest.newBuilder(
                URI.create(baseURL + searchType + apiKey + title.replace(" ", "%20")))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        List<TitleSearchResult> titleSearchResultList = new ArrayList<>();

        for (JsonNode movieObj : responseNodeTree.get("results")) {
            titleSearchResultList.add(new TitleSearchResult(movieObj));
        }

        titleSearchResultRepository.saveAll(titleSearchResultList);

        return titleSearchResultList.size() + " movies found";

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

        TitleIdResult movieObj = new TitleIdResult(responseNodeTree);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(movieObj);

    }

}
