package com.ironhack.playlistservice.dao;

import com.ironhack.playlistservice.enums.PlaylistType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    private long userId;

    private String type;

    @OneToMany(mappedBy = "playlistId", cascade = CascadeType.ALL)
    private List<Movie> movies;

    public Playlist(String name, int length, long userId) {
        this.name = name;
        this.length = length;
        this.userId = userId;
        this.type = "PUBLIC";
        this.movies = new ArrayList<Movie>();
    }

    public void setLength(int length) {
        if(length <= 10) {
            this.length = length;
        }
    }

    public void setMovies(List<Movie> movies) {
        if(movies.size() <= 10) {
            this.movies = movies;
        }
    }
}
