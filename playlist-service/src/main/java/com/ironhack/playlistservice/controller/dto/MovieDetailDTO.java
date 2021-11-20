package com.ironhack.playlistservice.controller.dto;

import com.ironhack.playlistservice.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailDTO {

    private String titleId;

    private URI imageURI;

    private String title;

    private String description;

    public MovieDetailDTO(URI imageURI, String title) {
        this.imageURI = imageURI;
        this.title = title;
    }
}
