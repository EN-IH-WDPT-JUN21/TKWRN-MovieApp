package com.ironhack.playlistservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistRequestDTO {

    private String name;

    private int length;

    private String username;

    private String type;

    public PlaylistRequestDTO(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public PlaylistRequestDTO(String name) {
        this.name = name;
    }
}
