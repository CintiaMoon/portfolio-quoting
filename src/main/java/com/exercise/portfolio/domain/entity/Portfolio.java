package com.exercise.portfolio.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Portfolio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private HashSet<String> symbols;
	
	private BigDecimal cashDollars;
	
	private BigDecimal cashEuros;
	
	
	@OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY)
    private List<PortfolioStock> stocks;
	
    @OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY)
    private List<PortfolioBond> bonds;

    @OneToMany(mappedBy = "portfolio", fetch = FetchType.LAZY)
    private List<PortfolioCurrency> currencies;
}
