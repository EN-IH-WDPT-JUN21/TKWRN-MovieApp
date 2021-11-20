package com.ironhack.playlistservice.dao;

import com.ironhack.playlistservice.enums.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URI;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name=" TITLE_SEARCH_RESULT")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titleId;

    @Column(name = "result_type")
    private ResultType type;

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
