package com.exercise.portfolio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.portfolio.domain.dto.PortfolioDto;
import com.exercise.portfolio.service.PortfolioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Portfolio Management Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Portfolio Management" })
@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

	@Autowired
	PortfolioService portfolioService;

	@ApiOperation(value = "Get current value of the portfolio either in US Dollars or in Euro", notes = "Retrieves current value")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved portfolio") })
	@GetMapping("/current/{portfolioId}")
	public ResponseEntity<PortfolioDto>getCurrentValue(@PathVariable(value = "portfolioId", required = true) int portfolioId,
			HttpServletRequest request) {
		PortfolioDto portfolio = portfolioService.getCurrentValue(portfolioId);
		return new ResponseEntity<>(portfolio, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "Get Portfolio", notes = "Retrieves Portfolio")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved portfolio") })
//	@GetMapping("/profit/{portfolioId}")
//	public ResponseEntity<List<ProfitAndLossDto>> getProfitAndLos(@PathVariable(value = "portfolioId", required = true) int portfolioId,
//			HttpServletRequest request) {
//		portfolioService.getCurrentValue(portfolioId);
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
}
