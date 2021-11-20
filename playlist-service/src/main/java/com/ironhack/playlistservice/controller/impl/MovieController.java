package com.ironhack.playlistservice.controller.impl;

import com.ironhack.playlistservice.controller.dto.MovieDetailDTO;
import com.ironhack.playlistservice.dao.Movie;
import com.ironhack.playlistservice.repository.MovieRepository;
import com.ironhack.playlistservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    final MovieService movieService;

    final MovieRepository movieRepository;

    public MovieController(MovieService movieService, MovieRepository movieRepository) {
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieById(@PathVariable(name = "id") long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public MovieDetailDTO getByName(@RequestParam(value="title") String title) {
        return movieService.getMovieByTitle(title);
    }

//    @GetMapping("/get")
//    @ResponseStatus(HttpStatus.OK)
//    public List<MovieDetailDTO> getMoviesByPlaylist(@RequestParam(value="id") long id) {
//        return movieService.getByPlaylist(id);
//    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie(@PathVariable(name = "id") long id) {
        movieRepository.deleteById(id);
    }
}
