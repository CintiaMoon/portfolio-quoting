package com.exercise.portfolio.domain.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PortfolioDto {

	private BigDecimal currentTotalValueDollars;
	private BigDecimal currentTotalValueEuros;
}
