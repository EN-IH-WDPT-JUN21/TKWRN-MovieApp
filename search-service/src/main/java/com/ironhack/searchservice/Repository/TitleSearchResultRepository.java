package com.ironhack.searchservice.Repository;

import com.ironhack.searchservice.dao.TitleSearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleSearchResultRepository extends JpaRepository<TitleSearchResult, Long> {
}
