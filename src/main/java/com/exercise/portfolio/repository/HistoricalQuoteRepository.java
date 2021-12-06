package com.exercise.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exercise.portfolio.domain.dto.HistoricalQuoteVolume;
import com.exercise.portfolio.domain.entity.HistoricalQuote;

public interface HistoricalQuoteRepository extends JpaRepository<HistoricalQuote, Long>{

	
	@Query("SELECT new com.exercise.portfolio.domain.dto.HistoricalQuoteVolume (h.symbol, SUM(h.volume)) FROM HistoricalQuote AS h GROUP BY h.symbol ORDER BY h.symbol DESC")
	List<HistoricalQuoteVolume> getTotalQuote();
	
}
