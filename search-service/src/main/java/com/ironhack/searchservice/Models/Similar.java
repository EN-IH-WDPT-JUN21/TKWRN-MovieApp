package com.ironhack.searchservice.Models;

import com.fasterxml.jackson.databind.JsonNode;

import java.net.URI;
import java.net.URISyntaxException;

public class Similar {

    private String titleId;
    private String title;
    private URI titleImage;

    public Similar(JsonNode similar) throws URISyntaxException {
        this.titleId = similar.get("id").asText();
        this.title = similar.get("title").asText();
        this.titleImage = new URI(similar.get("image").asText());
    }
}
