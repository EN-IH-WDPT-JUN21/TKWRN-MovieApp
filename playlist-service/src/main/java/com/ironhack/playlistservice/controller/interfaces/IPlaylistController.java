package com.ironhack.playlistservice.controller.interfaces;

import com.ironhack.playlistservice.dao.Playlist;

import java.util.List;

public interface IPlaylistController {

    List<Playlist> getByUserId(long id);

    List<Playlist> getByName(String name);
}
