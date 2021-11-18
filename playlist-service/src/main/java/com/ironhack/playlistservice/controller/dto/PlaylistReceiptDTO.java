package com.ironhack.playlistservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistReceiptDTO {

    private String name;

    private int length;

    private String username;

    private String type;

    private List<MovieDetailDTO> playlistMovies;
}
