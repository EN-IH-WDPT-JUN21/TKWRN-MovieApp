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
public class Similar {

    private String titleId;
    private String title;
    private URI titleImage;

    public Similar(JsonNode similar) throws URISyntaxException {
        this.titleId = similar.get("id").asText();
        this.title = similar.get("title").asText();
        this.titleImage = new URI(similar.get("image").asText());
    }

    @Override
    public String toString() {
        return "Similar{" +
                "titleId='" + titleId + '\'' +
                ", title='" + title + '\'' +
                ", titleImage=" + titleImage +
                '}';
    }
}
