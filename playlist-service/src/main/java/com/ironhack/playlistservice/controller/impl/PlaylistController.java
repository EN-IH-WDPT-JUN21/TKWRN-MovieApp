package com.ironhack.playlistservice.controller.impl;

import com.ironhack.playlistservice.controller.dto.MovieDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.controller.interfaces.IPlaylistController;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import com.ironhack.playlistservice.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/playlists")
public class PlaylistController implements IPlaylistController {

    private PlaylistService playlistService;

    private PlaylistRepository playlistRepository;

    public PlaylistController(PlaylistService playlistService, PlaylistRepository playlistRepository) {
        this.playlistService = playlistService;
        this.playlistRepository = playlistRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Playlist getPlaylistById(@PathVariable(name = "id") long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @GetMapping("/get/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<Playlist> getUserPlaylists(@PathVariable(name = "username") String username) {
        return playlistService.getPlaylistsByUser(username);
    }

    @GetMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDTO> getMoviesInPlaylist(@PathVariable(name = "id") String id) {
        return playlistService.getMoviesByPlaylist(id);
    }

    @PutMapping("/addmovie/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Playlist updatePlaylist(@PathVariable(name = "id") long id,
                                   @RequestBody MovieDTO movie) {
        System.out.println(movie.toString());
        return playlistService.addMovie(id, movie);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Playlist createPlaylist(@RequestBody @Valid PlaylistRequestDTO playlistRequestDTO) {
        return playlistService.create(playlistRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlaylist(@PathVariable(name = "id") long id) {
        playlistRepository.deleteById(id);
    }
}
