package com.ironhack.searchservice.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Models.CastMovie;
import com.ironhack.searchservice.Models.KnownFor;
import com.ironhack.searchservice.Models.Similar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonIdResult {

    private String name;
    private String role;
    private URI imageURI;
    private String summary;
    private String birthDate;
    private String deathDate;
    private String awards;
    private List<KnownFor> knownForList;
    private List<CastMovie> castMovieList;

    public PersonIdResult(JsonNode personObj) throws URISyntaxException {
        this.name = personObj.get("name").asText();
        this.role = personObj.get("role").asText();
        this.imageURI = new URI(personObj.get("image").asText());
        this.summary = personObj.get("summary").asText();
        this.birthDate = personObj.get("birthDate").asText();
        this.deathDate = personObj.get("deathDate").asText();
        this.awards = personObj.get("awards").asText();

        this.knownForList = new ArrayList<>();
        for (var i = 0; i < personObj.get("knownFor").size(); i++){
            knownForList.add(new KnownFor(personObj.get("knownFor").get(i)));
        }

        this.castMovieList = new ArrayList<>();
        for (var i = 0; i < personObj.get("castMovies").size(); i++){
            castMovieList.add(new CastMovie(personObj.get("castMovies").get(i)));
        }
    }

    @Override
    public String toString() {
        return "PersonIdResult{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", imageURI=" + imageURI +
                ", summary='" + summary + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", deathDate='" + deathDate + '\'' +
                ", awards='" + awards + '\'' +
                ", knownForList=" + knownForList +
                ", castMovieList=" + castMovieList +
                '}';
    }
}
