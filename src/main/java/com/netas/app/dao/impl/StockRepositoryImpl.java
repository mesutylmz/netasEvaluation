package com.netas.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.netas.app.dao.api.StockRepository;
import com.netas.app.model.Role;
import com.netas.app.model.Stock;
@Repository("stockRepository")
public class StockRepositoryImpl implements StockRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Stock> getAll() {
		return entityManager.createQuery("from Stock",Stock.class).getResultList();
	}

	@Override
	public Stock getById(Long id) {
		return entityManager.find(Stock.class, id);
	}

	@Override
	public List<Stock> getByName(String name) {
		return entityManager.createQuery("from Stock where name = :name", Stock.class)
				.setParameter("name", name).getResultList();
	}

	@Override
	public List<Stock> getByCode(String code) {
		return entityManager.createQuery("from Stock where code = :code", Stock.class)
				.setParameter("code", code).getResultList();
	}

	@Transactional
	@Override
	public void createStock(Stock stockToCreate) {
		entityManager.persist(stockToCreate);
	}

	@Transactional
	@Override
	public Stock updateStock(Stock stockToUpdate) {
		return entityManager.merge(stockToUpdate);

	}
	@Transactional
	@Override
	public void deleteStock(Long id) {
		entityManager.remove(entityManager.getReference(Stock.class, id));
		
	}

}
