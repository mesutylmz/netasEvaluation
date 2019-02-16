package com.netas.app.dao.api;

import java.util.List;

import com.netas.app.model.Stock;

public interface StockRepository {
	List<Stock> 	getAll		();
	Stock 			getById		(Long id);
	List<Stock>		getByName	(String name);
	List<Stock> 	getByCode	(String code);
	
	void 	createStock (Stock stockToCreate);
	Stock	updateStock	(Stock stockToUpdate);
	void	deleteStock	(Long id);
}
