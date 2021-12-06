package com.exercise.portfolio.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Intrument implements Serializable{

	private String symbol;
	private BigDecimal volume;
	private BigDecimal price;
}
