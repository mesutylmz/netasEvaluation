package com.netas.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.netas.app.dao.api.UserRepository;
import com.netas.app.model.Role;
import com.netas.app.model.User;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository 
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getAll() {
		return entityManager.createQuery("from User",User.class).getResultList();
	}

	@Override
	public User getById(Long id) {
		return entityManager.find(User.class, id);

	}

	@Override
	public List<User> getByName(String name) {
		return entityManager.createQuery("from User where lower(name) = lower(:name)",User.class).setParameter("name", name).getResultList();
	}

	@Override
	public List<User> getByPhoneNumber(String phoneNumber) {
		return entityManager.createQuery("from User where lower(phoneNumber) = lower(:phoneNumber)",User.class).setParameter("phoneNumber", phoneNumber).getResultList();
	}

	@Transactional
	@Override
	public void createUser(User userToCreate) {
		entityManager.persist(userToCreate);		
	}

	@Transactional
	@Override
	public User updateUser(User userToUpdate) {
		return entityManager.merge(userToUpdate);		
	}

	@Transactional
	@Override
	public void deleteuser(Long id) {
		entityManager.remove(entityManager.getReference(User.class, id));
		
	}

	
}
