package com.ironhack.playlistservice.service;

import com.ironhack.playlistservice.controller.dto.MovieDetailDTO;
import com.ironhack.playlistservice.dao.Movie;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.MovieRepository;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PlaylistRepository playlistRepository;

    public MovieDetailDTO getMovieByTitle(String title) {
        Movie movie = movieRepository.getByTitle(title);
        MovieDetailDTO movieDetail = new MovieDetailDTO(movie.getTitleId(), movie.getImageURI(), movie.getTitle(), movie.getDescription());
        return movieDetail;
    }
}
