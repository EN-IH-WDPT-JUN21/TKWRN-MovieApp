package com.ironhack.playlistservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private String titleId;
    private URI imageURI;
    private String title;
    private String description;

    @Override
    public String toString() {
        return "MovieDTO{" +
                "titleId='" + titleId + '\'' +
                ", imageURI=" + imageURI +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
