package com.ironhack.searchservice.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Enum.ResponseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URI;
import java.util.Locale;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieTitleSearchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleId;
    private ResponseType responseType;
    private URI imageURI;
    private String title;
    private String description;


    public MovieTitleSearchResult(JsonNode movieObj) {
        this.titleId = movieObj.get("id").asText();
        this.responseType = ResponseType.valueOf(movieObj.get("resultType").asText().toUpperCase(Locale.ROOT));
        this.imageURI = URI.create(movieObj.get("image").asText());
        this.title = movieObj.get("title").asText();
        this.description = movieObj.get("description").asText();
    }
}
