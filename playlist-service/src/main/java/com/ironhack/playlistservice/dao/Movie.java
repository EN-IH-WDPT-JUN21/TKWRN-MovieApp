package com.ironhack.playlistservice.dao;

import com.ironhack.playlistservice.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URI;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titleId;

    private ResultType resultType;

    private URI imageURI;

    private String title;

    private String description;

    public Movie(String titleId, URI imageURI, String title, String description) {
        this.titleId = titleId;
        this.imageURI = imageURI;
        this.title = title;
        this.description = description;
    }
}
