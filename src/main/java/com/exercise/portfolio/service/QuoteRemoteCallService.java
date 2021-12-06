package com.exercise.portfolio.service;

import java.math.BigDecimal;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.exercise.portfolio.domain.CurrentQuoteValue;

import lombok.extern.slf4j.Slf4j;

/**
 * Retrieves quotes from a quote service.
 * 
 * @author cintiaargain
 *
 */
@Service
@Slf4j
public class QuoteRemoteCallService {

	
	public Hashtable<String, CurrentQuoteValue> retrieveCurrentQuoteValues(Long portfolioId) {
		log.debug("Fetching portfolio Id quotes: {} ",portfolioId);
		
		Hashtable<String, CurrentQuoteValue> currentQuotes = new Hashtable<>();

		currentQuotes.put("GE",
				CurrentQuoteValue.builder().dollars(new BigDecimal(5)).euros(new BigDecimal(4)).build());
		currentQuotes.put("GO",
				CurrentQuoteValue.builder().dollars(new BigDecimal(10)).euros(new BigDecimal(9)).build());
		currentQuotes.put("AM",
				CurrentQuoteValue.builder().dollars(new BigDecimal(15)).euros(new BigDecimal(8)).build());

		return currentQuotes;
	}
}
