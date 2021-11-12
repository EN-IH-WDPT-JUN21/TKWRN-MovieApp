package com.ironhack.searchservice.Repository;

import com.ironhack.searchservice.dao.MovieTitleSearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTitleSearchResultRepository extends JpaRepository<MovieTitleSearchResult, Long> {
}
