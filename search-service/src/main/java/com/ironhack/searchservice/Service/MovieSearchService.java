package com.ironhack.searchservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Repository.PopularMoviesRepository;
import com.ironhack.searchservice.Repository.PopularSeriesRepository;
import com.ironhack.searchservice.Repository.TitleSearchResultRepository;
import com.ironhack.searchservice.Utils.UncheckedObjectMapper;
import com.ironhack.searchservice.dao.PopularResults;
import com.ironhack.searchservice.dao.TitleIdResult;
import com.ironhack.searchservice.dao.TitleSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.DayOfWeek;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class MovieSearchService {

    @Autowired
    TitleSearchResultRepository titleSearchResultRepository;

    @Autowired
    PopularMoviesRepository popularMoviesRepository;

    @Autowired
    PopularSeriesRepository popularSeriesRepository;

    private final String baseURL = "https://imdb-api.com/en/API/";
    private final String apiKey = "/k_j0n3xy71/";
    private HttpClient client = HttpClient.newHttpClient();

    public List<TitleSearchResult> searchByMovieTitle(String type, String title) throws ExecutionException, InterruptedException, JsonProcessingException {

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

        return titleSearchResultList;

    }


    public TitleIdResult searchByTitleId(String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
        var request = HttpRequest.newBuilder(
                URI.create(baseURL + "Title" + apiKey + id))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        TitleIdResult movieObj = new TitleIdResult(responseNodeTree);

        return movieObj;

    }

    public List<PopularResults> searchPopular(String type) throws ExecutionException, InterruptedException, JsonProcessingException {

        Optional<PopularResults> foundResult = popularMoviesRepository.findById(0L);
        if (foundResult.isPresent()){
            Calendar now = Calendar.getInstance();
            if (foundResult.get().getDateOfLastSearch().get(Calendar.DAY_OF_WEEK) == now.get(Calendar.DAY_OF_WEEK)){
                if(type.equals("Movies")){
                    return popularMoviesRepository.findAll();
                }
                else if (type.equals("TVs")){
                    return popularSeriesRepository.findAll();
                }
            }
        }

        var request = HttpRequest.newBuilder(
                URI.create(baseURL + "MostPopular" + type + apiKey))
                .build();

        CompletableFuture<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        String searchResultJSON = response.get();

        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();

        JsonNode responseNodeTree = objectMapper.readTree(searchResultJSON);

        List<PopularResults> popularResultList = new ArrayList<>();

        for (JsonNode movieObj : responseNodeTree.get("results")) {
            popularResultList.add(new PopularResults(movieObj));
        }

        if(type.equals("Movies")){
            popularMoviesRepository.saveAll(popularResultList);
        }
        else if (type.equals("TVs")){
            popularSeriesRepository.saveAll(popularResultList);
        }

        return popularResultList;

    }

}
