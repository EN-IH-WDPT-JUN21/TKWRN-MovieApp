package com.ironhack.searchservice.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ironhack.searchservice.Service.MovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/search/get")
public class MovieSearchController {

    @Autowired
    MovieSearchService movieSearchService;

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public String getMoviesByTitle(@PathVariable String title) throws ExecutionException, InterruptedException, JsonProcessingException {
        return movieSearchService.searchByTitle(title);
    }

    @GetMapping("/titleId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getMovieByTitleId(@PathVariable String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
        return movieSearchService.searchByTitleId(id);
    }

}
