package com.ironhack.searchservice.dao;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.URI;
import java.util.Locale;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TitleSearchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleId;
    private ResultType resultType;
    private URI imageURI;
    private String title;
    private String description;


    public TitleSearchResult(JsonNode movieObj) {
        this.titleId = movieObj.get("id").asText();
        this.resultType = ResultType.valueOf(movieObj.get("resultType").asText().toUpperCase(Locale.ROOT));
        this.imageURI = URI.create(movieObj.get("image").asText());
        this.title = movieObj.get("title").asText();
        this.description = movieObj.get("description").asText();
    }
}
