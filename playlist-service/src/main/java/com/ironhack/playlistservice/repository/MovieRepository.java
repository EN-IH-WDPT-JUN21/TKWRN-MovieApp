package com.ironhack.playlistservice.repository;

import com.ironhack.playlistservice.controller.dto.MovieDetailDTO;
import com.ironhack.playlistservice.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie getByTitle(String title);
}
