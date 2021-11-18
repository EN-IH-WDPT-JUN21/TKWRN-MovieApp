package com.ironhack.playlistservice.controller.impl;

import com.ironhack.playlistservice.controller.dto.MovieDetailDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistReceiptDTO;
import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.controller.interfaces.IPlaylistController;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import com.ironhack.playlistservice.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin(origins = "http://localhost:4200")
public class PlaylistController implements IPlaylistController {

    final PlaylistService playlistService;

    final PlaylistRepository playlistRepository;

    public PlaylistController(PlaylistService playlistService, PlaylistRepository playlistRepository) {
        this.playlistService = playlistService;
        this.playlistRepository = playlistRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Playlist> getPlaylists() {
        return playlistRepository.findAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Playlist getPlaylistById(@PathVariable(name = "id") long id) {
        return playlistRepository.findById(id).orElse(null);
    }

//    @GetMapping("/{userId}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Playlist> getByUserId(@PathVariable(name = "userId") long userId) {
//        return playlistService.getByUser(userId);
//    }

    @Override
    public List<Playlist> getByUserId(long id) {
        return null;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Playlist> getByName(@RequestParam(value="name") String name) {
        return playlistService.getByPlaylistName(name);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Playlist updatePlaylistName(@PathVariable(name = "id") long id,
                                       @RequestBody PlaylistRequestDTO playlistRequestDTO) {
        return playlistService.updateName(id, playlistRequestDTO);
    }

    @PutMapping("/update/{id}/add")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PlaylistReceiptDTO addNewMovie(@PathVariable(name = "id") long id,
                                          @RequestBody MovieDetailDTO movieDetailDTO) {
        return playlistService.addMovie(id, movieDetailDTO);
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

