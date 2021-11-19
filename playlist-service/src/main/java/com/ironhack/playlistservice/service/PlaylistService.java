package com.ironhack.playlistservice.service;

import com.ironhack.playlistservice.controller.dto.MovieDetailDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistReceiptDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

//    public List<Playlist> getByUsername(String username) {
//        return null;
//    }

    public List<Playlist> getByPlaylistName(String name) {
        List<Playlist> playlists = playlistRepository.getByName(name);
        return playlists;
    }

    public Playlist updateName(long id, PlaylistRequestDTO playlistRequestDTO) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        if (optionalPlaylist.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no playlist with this id. Please, try again");
        }
        Playlist playlistStored = optionalPlaylist.get();
        playlistStored.setName(playlistRequestDTO.getName());
        playlistRepository.save(playlistStored);
        return playlistStored;
    }

    public PlaylistReceiptDTO addMovie(long id, MovieDetailDTO movieDetailDTO) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        if(optionalPlaylist.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no playlist with this id. Please, try again");
        }
        Playlist playlistStored = optionalPlaylist.get();
        List<MovieDetailDTO> movies = new ArrayList<>();
        MovieDetailDTO newMovie = new MovieDetailDTO(movieDetailDTO.getTitleId(), movieDetailDTO.getImageURI(),
                movieDetailDTO.getTitle(), movieDetailDTO.getDescription());
        movies.add(newMovie);
        PlaylistReceiptDTO playlistReceiptDTO = new PlaylistReceiptDTO(playlistStored.getName(),
                playlistStored.getLength(),
                playlistStored.getUsername(),
                playlistStored.getType().toString(),
                movies);
        playlistRepository.save(playlistStored);
        return playlistReceiptDTO;
    }

//    public Playlist create(PlaylistRequestDTO playlistRequestDTO) {
//        Playlist playlist = new Playlist(playlistRequestDTO.getName(), playlistRequestDTO.getLength(), playlistRequestDTO.getUserId());
//        playlistRepository.save(playlist);
//        PlaylistReceiptDTO playlistReceiptDTO = new PlaylistReceiptDTO(playlist.getName(), playlist.getLength(), playlist.getUserId());
//        return playlist;
//    }

    public Playlist create(PlaylistRequestDTO playlistRequestDTO) {
        Playlist playlist = new Playlist(playlistRequestDTO.getName(), playlistRequestDTO.getUsername());
        if(playlistRepository.count() <= 10) {
            playlistRepository.save(playlist);
        }
//        PlaylistReceiptDTO playlistReceiptDTO = new PlaylistReceiptDTO(playlist.getName(), playlist.getLength());
        return playlist;
    }
}
