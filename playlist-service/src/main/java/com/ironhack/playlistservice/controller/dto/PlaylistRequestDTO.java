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

    private long userId;

    private String type;


}
