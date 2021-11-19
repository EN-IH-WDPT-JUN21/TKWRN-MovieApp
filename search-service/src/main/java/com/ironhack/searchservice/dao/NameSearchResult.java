package com.ironhack.searchservice.dao;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.util.Locale;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NameSearchResult {

    private String nameId;
    private URI imageURI;
    private String title;
    private String description;

    public NameSearchResult(JsonNode personObj) {
        this.nameId = personObj.get("id").asText();
        this.imageURI = URI.create(personObj.get("image").asText());
        this.title = personObj.get("title").asText();
        this.description = personObj.get("description").asText();
    }

    @Override
    public String toString() {
        return "NameSearchResult{" +
                "nameId='" + nameId + '\'' +
                ", imageURI=" + imageURI +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
