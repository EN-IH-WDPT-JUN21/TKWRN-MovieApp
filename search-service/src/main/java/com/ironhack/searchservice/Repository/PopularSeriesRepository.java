package com.ironhack.searchservice.Repository;

import com.ironhack.searchservice.dao.PopularSeriesResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularSeriesRepository extends JpaRepository<PopularSeriesResults, Long> {
}
