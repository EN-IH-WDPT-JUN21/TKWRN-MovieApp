package com.ironhack.playlistservice.controller.dto;

import com.ironhack.playlistservice.dao.Movie;
import com.ironhack.playlistservice.enums.PlaylistType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistRequestDTO {

    private String name;

    private int length;

    private long userId;

    private String type;

    private List<Movie> movies;
}
