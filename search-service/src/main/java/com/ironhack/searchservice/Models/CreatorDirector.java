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
public class CreatorDirector {

    private String directorId;
    private String name;

    public CreatorDirector(JsonNode directors) {
        this.directorId = directors.get("id").asText();
        this.name = directors.get("name").asText();
    }

    @Override
    public String toString() {
        return "CreatorDirector{" +
                "directorId='" + directorId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
