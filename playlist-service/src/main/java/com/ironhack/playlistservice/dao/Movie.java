package com.ironhack.playlistservice.dao;

import com.ironhack.playlistservice.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URI;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "playlistId")
    private Playlist playlist;
    private String titleId;
    private URI imageURI;
    private String title;
    private String description;

    public Movie(Playlist playlist, String titleId, URI imageURI, String title, String description) {
        this.playlist = playlist;
        this.titleId = titleId;
        this.imageURI = imageURI;
        this.title = title;
        this.description = description;
    }

    public Movie(String titleId, URI imageURI, String title, String description) {
        this.titleId = titleId;
        this.imageURI = imageURI;
        this.title = title;
        this.description = description;
    }
}