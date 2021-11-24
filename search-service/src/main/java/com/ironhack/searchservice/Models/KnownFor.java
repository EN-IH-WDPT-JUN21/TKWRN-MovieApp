package com.ironhack.searchservice.Models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.net.URISyntaxException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KnownFor {

    private String titleId;
    private String title;
    private String year;
    private String role;
    private URI imageURI;


    public KnownFor(JsonNode knownFor) throws URISyntaxException {
        this.titleId = knownFor.get("id").asText();
        this.title = knownFor.get("title").asText();
        this.year = knownFor.get("year").asText();
        this.role = knownFor.get("role").asText();
        this.imageURI = new URI(knownFor.get("image").asText());
    }

    @Override
    public String toString() {
        return "KnownFor{" +
                "titleId='" + titleId + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", role='" + role + '\'' +
                ", imageURI=" + imageURI +
                '}';
    }
}
