package com.ironhack.searchservice.Repository;

import com.ironhack.searchservice.dao.PopularResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopularSeriesRepository extends JpaRepository<PopularResults, Long> {
}
