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
public class Star {

    private String personId;
    private URI imageURI;
    private String name;
    private String asCharacter;

    public Star(JsonNode star) throws URISyntaxException {
        this.personId = star.get("id").asText();
        this.imageURI = new URI(star.get("image").asText());
        this.name = star.get("name").asText();
        this.asCharacter = star.get("asCharacter").asText();
    }

    @Override
    public String toString() {
        return "Star{" +
                "personId='" + personId + '\'' +
                ", imageURI=" + imageURI +
                ", name='" + name + '\'' +
                ", asCharacter='" + asCharacter + '\'' +
                '}';
    }
}
