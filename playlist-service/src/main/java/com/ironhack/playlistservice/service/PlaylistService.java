package com.ironhack.playlistservice.service;

import com.ironhack.playlistservice.controller.dto.MovieDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.dao.Movie;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getByUser(long userId) {
        return null;
    }

    public List<Playlist> getByName(String name) {
        return null;
    }

    public Playlist update(long id, PlaylistRequestDTO playlistRequestDTO) {
        return null;
    }

    public Playlist create(PlaylistRequestDTO playlistRequestDTO) {
        Playlist newPlaylist = new Playlist(
                playlistRequestDTO.getName(),
                playlistRequestDTO.getLength(),
                playlistRequestDTO.getUserId()
        );
        return playlistRepository.save(newPlaylist);
    }

    public Playlist addMovie(long id, MovieDTO movie) {
        System.out.println(movie.getTitle());
        Playlist foundPlaylist = playlistRepository.findById(id).get();
        List<Movie> movieList = foundPlaylist.getMovies();
        movieList.add(new Movie(
                movie.getTitleId(),
                movie.getImageURI(),
                movie.getTitle(),
                movie.getDescription()));
        foundPlaylist.setMovies(movieList);
        foundPlaylist.setLength(foundPlaylist.getLength() + 1);
        return playlistRepository.save(foundPlaylist);
    }

    public List<MovieDTO> getMoviesByPlaylist(long id) {
        Playlist foundPlaylist = playlistRepository.findById(id).get();
        List<MovieDTO> moviesList = new ArrayList<>();
        for (var movie : foundPlaylist.getMovies()){
            moviesList.add(new MovieDTO(
                    movie.getTitleId(),
                    movie.getImageURI(),
                    movie.getTitle(),
                    movie.getDescription()
            ));
        }
        return moviesList;
    }
}
