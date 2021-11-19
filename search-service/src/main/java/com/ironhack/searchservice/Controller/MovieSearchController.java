package com.ironhack.searchservice.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ironhack.searchservice.Service.MovieSearchService;
import com.ironhack.searchservice.Service.PersonSearchService;
import com.ironhack.searchservice.dao.NameSearchResult;
import com.ironhack.searchservice.dao.PersonIdResult;
import com.ironhack.searchservice.dao.TitleIdResult;
import com.ironhack.searchservice.dao.TitleSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/search")
public class MovieSearchController {

    @Autowired
    MovieSearchService movieSearchService;
    @Autowired
    PersonSearchService personSearchService;

    @GetMapping("/title/{type}/{title:[a-zA-Z &+-]*}")
    @ResponseStatus(HttpStatus.OK)
    public List<TitleSearchResult> getMoviesByTitle(@PathVariable String type, @PathVariable String title) throws ExecutionException, InterruptedException, JsonProcessingException {
        return movieSearchService.searchByMovieTitle(type, title);
    }

    @GetMapping("/title/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TitleIdResult getTitleByTitleId(@PathVariable String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
        return movieSearchService.searchByTitleId(id);
    }

    @GetMapping("/person/{name:[a-zA-Z &+-]*}")
    @ResponseStatus(HttpStatus.OK)
    public List<NameSearchResult> getPersonsByName(@PathVariable String name) throws ExecutionException, InterruptedException, JsonProcessingException {
        return personSearchService.searchByName(name);
    }

    @GetMapping("/personId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonIdResult getPersonByNameId(@PathVariable String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
        return personSearchService.searchByNameId(id);
    }


}
