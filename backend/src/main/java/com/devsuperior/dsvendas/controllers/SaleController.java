 package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.service.SaleService;

/**
 * Controller REST para endpoints relacionados a vendas.
 * 
 * Fornece endpoints para consultar vendas, agregações e estatísticas.
 */
@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	/**
	 * Lista todas as vendas com paginação.
	 * 
	 * @param pageable Parâmetros de paginação (page, size, sort)
	 * @return ResponseEntity com página de vendas
	 */
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);		
	}
	
	/**
	 * Retorna a soma total de vendas por vendedor.
	 * 
	 * @return ResponseEntity com lista de somas por vendedor
	 */
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);		
	}
	
	/**
	 * Retorna a taxa de sucesso por vendedor.
	 * 
	 * @return ResponseEntity com estatísticas de sucesso por vendedor
	 */
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);		
	}


}
