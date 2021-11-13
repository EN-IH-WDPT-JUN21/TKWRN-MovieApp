package com.ironhack.searchservice.Models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CastMovie {

    private String titleId;
    private String role;
    private String title;
    private String year;
    private String description;

    public CastMovie(JsonNode castMovies) {
        this.titleId = castMovies.get("id").asText();
        this.role = castMovies.get("role").asText();
        this.title = castMovies.get("title").asText();
        this.year = castMovies.get("year").asText();
        this.description = castMovies.get("description").asText();
    }

    @Override
    public String toString() {
        return "CastMovie{" +
                "titleId='" + titleId + '\'' +
                ", role='" + role + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
