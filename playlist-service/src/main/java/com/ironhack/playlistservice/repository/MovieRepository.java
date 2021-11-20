package com.ironhack.playlistservice.repository;

import com.ironhack.playlistservice.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
