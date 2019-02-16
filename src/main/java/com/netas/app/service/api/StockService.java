package com.netas.app.service.api;

import java.util.List;

import com.netas.app.model.Stock;

public interface StockService {
	List<Stock> 	findStocks	();
	List<Stock> 	findByName	(String name);
	List<Stock> 	findByCode	(String code);
	
	Stock		findStock	(Long id);
	void 		createStock	(Stock stock);
	void		updateStock	(Stock stock);
	void		deleteStock	(Long id);
}
