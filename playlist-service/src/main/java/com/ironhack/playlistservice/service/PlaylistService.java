package com.ironhack.playlistservice.service;

import com.ironhack.playlistservice.controller.dto.PlaylistRequestDTO;
import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

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
                playlistRequestDTO.getUserId(),
                playlistRequestDTO.getType()
        );
        return playlistRepository.save(newPlaylist);
    }
}
