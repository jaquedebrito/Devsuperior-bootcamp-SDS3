package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

/**
 * Serviço responsável pela lógica de negócio relacionada a vendas.
 * 
 * Fornece métodos para consultar vendas, agregações e estatísticas.
 */
@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	/**
	 * Retorna uma página de vendas.
	 * 
	 * @param pageable Informações de paginação (página, tamanho, ordenação)
	 * @return Página de SaleDTO com os dados das vendas
	 */
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		// Busca todos os vendedores para popular cache
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));		
	}
	
	/**
	 * Retorna a soma total de vendas agrupada por vendedor.
	 * 
	 * @return Lista de SaleSumDTO com o nome do vendedor e soma das vendas
	 */
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
		
	}
	
	/**
	 * Retorna a taxa de sucesso (deals/visited) agrupada por vendedor.
	 * 
	 * @return Lista de SaleSuccessDTO com estatísticas de sucesso por vendedor
	 */
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
		
	}
		
}