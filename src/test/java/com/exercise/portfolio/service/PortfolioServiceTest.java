package com.exercise.portfolio.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.exercise.portfolio.domain.dto.HistoricalQuoteVolume;
import com.exercise.portfolio.domain.dto.PortfolioDto;
import com.exercise.portfolio.repository.HistoricalQuoteRepository;

@ExtendWith(SpringExtension.class)
@Import({ PortfolioService.class, QuoteRemoteCallService.class })
@ActiveProfiles("test")
@DisplayName("Given a service for handling portfolios")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodName.class)
public class PortfolioServiceTest {

	
	@Autowired
	PortfolioService portfolioService;
	
	@MockBean
	HistoricalQuoteRepository historicalQuoteRepository;

	
	@Test
	public void testGetCurrentValue_Expect_null() {
		
		
		doReturn(getTotalQuotes()).when(historicalQuoteRepository).getTotalQuote();
		
		PortfolioDto result = portfolioService.getCurrentValue(1l);
		
		assertNotNull(result);
	}
	
	
	private  List<HistoricalQuoteVolume> getTotalQuotes(){
		List<HistoricalQuoteVolume> hq = new ArrayList<HistoricalQuoteVolume>();
		
		
		hq.add(HistoricalQuoteVolume.builder().symbol("GE").volume(new BigDecimal(10)).build());
		hq.add(HistoricalQuoteVolume.builder().symbol("AM").volume(new BigDecimal(20)).build());
		return hq;
	}
	
}
