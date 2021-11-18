package com.ironhack.playlistservice.controller.dto;

import com.ironhack.playlistservice.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetailDTO {

    private String titleId;

    private ResultType resultType;

    private URI imageURI;

    private String title;

    private String description;

    public MovieDetailDTO(String titleId, URI imageURI, String title, String description) {
        this.titleId = titleId;
        this.imageURI = imageURI;
        this.title = title;
        this.description = description;
    }

    public MovieDetailDTO(URI imageURI, String title, String description) {
        this.imageURI = imageURI;
        this.title = title;
        this.description = description;
    }
}
