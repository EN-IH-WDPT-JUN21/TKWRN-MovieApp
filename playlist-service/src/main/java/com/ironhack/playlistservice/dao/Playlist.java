package com.ironhack.playlistservice.dao;

import com.ironhack.playlistservice.enums.PlaylistType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int length;

    private String username;

    @Enumerated(EnumType.STRING)
    private PlaylistType type;

    public Playlist(String name, String username) {
        this.name = name;
        this.length = 0;
        this.username = username;
        this.type = PlaylistType.PUBLIC;
    }

    public Playlist(String name, String username, PlaylistType type) {
        this.name = name;
        this.length = 0;
        this.username = username;
        this.type = type;
    }
}
