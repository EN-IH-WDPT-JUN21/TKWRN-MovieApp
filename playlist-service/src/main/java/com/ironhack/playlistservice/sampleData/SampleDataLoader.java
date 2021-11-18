package com.ironhack.playlistservice.sampleData;

import com.ironhack.playlistservice.dao.Playlist;
import com.ironhack.playlistservice.enums.PlaylistType;
import com.ironhack.playlistservice.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private PlaylistRepository playlistRepository;

    public SampleDataLoader(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public void run(String... args) throws Exception {
        this.playlistRepository.saveAll(List.of(new Playlist("My awesome playlist", "user1", PlaylistType.PUBLIC),
                new Playlist("Another awesome list", "user2", PlaylistType.PUBLIC),
                new Playlist("And a third one",  "user3", PlaylistType.PRIVATE)));
    }
}

