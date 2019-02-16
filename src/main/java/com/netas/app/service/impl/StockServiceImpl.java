package com.netas.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netas.app.dao.api.RoleRepository;
import com.netas.app.dao.api.StockRepository;
import com.netas.app.model.Stock;
import com.netas.app.service.api.StockService;

@Service
public class StockServiceImpl implements StockService{

	
	private StockRepository stockRepository;
	
	@Autowired
	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}
	@Override
	public List<Stock> findStocks() {
		return stockRepository.getAll();
	}

	@Override
	public List<Stock> findByName(String name) {
		return stockRepository.getByName(name);
	}

	@Override
	public List<Stock> findByCode(String code) {
		return stockRepository.getByCode(code);
	}

	@Override
	public Stock findStock(Long id) {
		return stockRepository.getById(id);
	}

	@Transactional
	@Override
	public void createStock(Stock stock) {
		stockRepository.createStock(stock);
		
	}
	@Transactional
	@Override
	public void updateStock(Stock stock) {
		stockRepository.updateStock(stock);
	}

	@Transactional
	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteStock(id);
	}

}
