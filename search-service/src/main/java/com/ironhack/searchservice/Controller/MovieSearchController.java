//package com.ironhack.searchservice.Controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.ironhack.searchservice.Service.MovieSearchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URISyntaxException;
//import java.util.concurrent.ExecutionException;
//
//@RestController
//@RequestMapping("/api/search/")
//public class MovieSearchController {
//
//    @Autowired
//    MovieSearchService movieSearchService;
//    @Autowired
//    PersonSearchService personSearchService;
//
//    @GetMapping("/title/{type}/{title:[a-zA-Z &+-]*}")
//    @ResponseStatus(HttpStatus.OK)
//    public String getMoviesByTitle(@PathVariable String type, @PathVariable String title) throws ExecutionException, InterruptedException, JsonProcessingException {
//        return movieSearchService.searchByMovieTitle(type, title);
//    }
//
//    @GetMapping("/title/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String getTitleByTitleId(@PathVariable String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
//        return movieSearchService.searchByTitleId(id);
//    }
//
//    @GetMapping("/person/{name:[a-zA-Z &+-]*}")
//    @ResponseStatus(HttpStatus.OK)
//    public String getPersonsByName(@PathVariable String name) throws ExecutionException, InterruptedException, JsonProcessingException {
//        return personSearchService.searchByName(name);
//    }
//
//    @GetMapping("/personId/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String getPersonByNameId(@PathVariable String id) throws ExecutionException, InterruptedException, JsonProcessingException, URISyntaxException {
//        return personSearchService.searchByNameId(id);
//    }
//
//
//}
