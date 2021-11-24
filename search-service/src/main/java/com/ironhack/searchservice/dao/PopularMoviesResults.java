package com.ironhack.searchservice.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.ironhack.searchservice.Enum.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PopularMoviesResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar dateOfLastSearch;
    private String titleRank;
    private String rankUpDown;
    private String titleId;
    private URI imageURI;
    private String title;


    public PopularMoviesResults(JsonNode movieObj) {
        this.titleId = movieObj.get("id").asText();
        this.titleRank = movieObj.get("rank").asText();
        this.rankUpDown = movieObj.get("rankUpDown").asText();
        this.imageURI = URI.create(movieObj.get("image").asText());
        this.title = movieObj.get("title").asText();
        this.dateOfLastSearch = Calendar.getInstance();
    }
}
