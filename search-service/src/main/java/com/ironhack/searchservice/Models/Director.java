package com.ironhack.searchservice.Models;

import com.fasterxml.jackson.databind.JsonNode;

public class Director {

    private String directorId;
    private String name;

    public Director(JsonNode directors) {
        this.directorId = directors.get("id").asText();
        this.name = directors.get("name").asText();
    }
}
