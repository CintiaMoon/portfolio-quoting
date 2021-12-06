package com.exercise.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.portfolio.domain.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
