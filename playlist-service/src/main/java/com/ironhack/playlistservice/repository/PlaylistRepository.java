package com.ironhack.playlistservice.repository;

import com.ironhack.playlistservice.dao.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    List<Playlist> getByName(String name);
}
