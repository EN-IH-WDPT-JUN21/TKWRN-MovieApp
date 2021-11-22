package com.ironhack.searchservice.Repository;

import com.ironhack.searchservice.dao.PopularMoviesResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularMoviesRepository extends JpaRepository<PopularMoviesResults, Long> {
}
