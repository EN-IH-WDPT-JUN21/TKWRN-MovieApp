package com.ironhack.searchservice.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Models.Director;
import com.ironhack.searchservice.Models.Similar;
import com.ironhack.searchservice.Models.Star;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieTitleIdSearchResult {

    private String title;
    private URI imageURI;
    private String releaseDate;
    private String runtime;
    private String plot;
    private List<Director> directorList;
    private List<Star> starList;
    private String genres;
    private String companies;
    private String contentRating;
    private String imdbRating;
    private int imdbRatingVotes;
    private List<Similar> similarList;

    public MovieTitleIdSearchResult(JsonNode movieObj) throws URISyntaxException {
        this.title = movieObj.get("title").asText();
        this.imageURI = new URI(movieObj.get("image").asText());
        this.releaseDate = movieObj.get("releaseDate").asText();
        this.runtime = movieObj.get("runtimeStr").asText();
        this.plot = movieObj.get("plot").asText();
        this.genres = movieObj.get("genres").asText();
        this.companies = movieObj.get("companies").asText();
        this.contentRating = movieObj.get("contentRating").asText();
        this.imdbRating = movieObj.get("imDbRating").asText();
        this.imdbRatingVotes = movieObj.get("imDbRatingVotes").asInt();

        this.directorList = new ArrayList<>();
        for (var i = 0; i < movieObj.get("directorList").size(); i++){
            directorList.add(new Director(movieObj.get("directorList").get(i)));
        }

        this.starList = new ArrayList<>();
        for (var i = 0; i < movieObj.get("actorList").size(); i++){
            starList.add(new Star(movieObj.get("actorList").get(i)));
        }

        this.similarList = new ArrayList<>();
        for (var i = 0; i < movieObj.get("similars").size(); i++){
            similarList.add(new Similar(movieObj.get("similars").get(i)));
        }
    }

    @Override
    public String toString() {
        return "MovieTitleIdSearchResult{" +
                "title='" + title + '\'' +
                ", imageURI=" + imageURI +
                ", releaseDate='" + releaseDate + '\'' +
                ", runtime='" + runtime + '\'' +
                ", plot='" + plot + '\'' +
                ", directorList=" + directorList +
                ", starList=" + starList +
                ", genres='" + genres + '\'' +
                ", companies='" + companies + '\'' +
                ", contentRating='" + contentRating + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbRatingVotes=" + imdbRatingVotes +
                ", similarList=" + similarList +
                '}';
    }
}
