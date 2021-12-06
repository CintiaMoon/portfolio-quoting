package com.exercise.portfolio.service;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.portfolio.domain.CurrentQuoteValue;
import com.exercise.portfolio.domain.dto.HistoricalQuoteVolume;
import com.exercise.portfolio.domain.dto.PortfolioDto;
import com.exercise.portfolio.domain.entity.Portfolio;
import com.exercise.portfolio.repository.HistoricalQuoteRepository;
import com.exercise.portfolio.repository.PortfolioRepository;

@Service
public class PortfolioService {

	@Autowired
	PortfolioRepository portfolioRepository;
	
	@Autowired
	HistoricalQuoteRepository historicalQuoteRepository;
	
	@Autowired
	QuoteRemoteCallService quoteRemoteCallService;

	/**
	 * Calculates the current value of the portfolio
	 * 
	 * @param portfolioId
	 * @return
	 */
	public PortfolioDto getCurrentValue(long portfolioId) {

		PortfolioDto portfolioDto = new PortfolioDto();
		
		Optional<Portfolio> portfolio = portfolioRepository.findById(portfolioId);
		
		if (portfolio.isPresent()) {
			
		}

		// Calculate Stock and bonds values
		Hashtable<String, CurrentQuoteValue> currentQuoteValue = quoteRemoteCallService.retrieveCurrentQuoteValues(portfolioId);

		List<HistoricalQuoteVolume> hqv = historicalQuoteRepository.getTotalQuote();
		
		BigDecimal currentTotalValueDollars = hqv.stream()
                .map(x -> x.getVolume().multiply(currentQuoteValue.get(x.getSymbol()).getDollars()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		
		BigDecimal currentTotalValueEuros = hqv.stream()
                .map(x -> x.getVolume().multiply(currentQuoteValue.get(x.getSymbol()).getEuros()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		
		// Calculate Bonds values
		
		portfolioDto.setCurrentTotalValueDollars(currentTotalValueDollars);
		portfolioDto.setCurrentTotalValueEuros(currentTotalValueEuros);
		
		return portfolioDto;
	}

}