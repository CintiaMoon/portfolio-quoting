package com.exercise.portfolio.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CurrentQuoteValue {
	
	private BigDecimal dollars;
	private BigDecimal euros;

}
