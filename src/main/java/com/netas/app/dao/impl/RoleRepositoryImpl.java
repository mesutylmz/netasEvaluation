package com.netas.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.netas.app.dao.api.RoleRepository;
import com.netas.app.model.Role;
import com.netas.app.model.User;
@Repository("roleRepository")
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Role> getAll() {
		return entityManager.createQuery("from Role",Role.class).getResultList();
	}

	@Override
	public Role getById(Long id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public List<Role> getByName(String name) {
		return entityManager.createQuery("from Role where name = :name", Role.class)
				.setParameter("name", name).getResultList();
	}

	@Transactional
	@Override
	public void createRole(Role roleToCreate) {
		entityManager.persist(roleToCreate);
	}

	@Transactional
	@Override
	public Role updateRole(Role roleToUpdate) {
		return entityManager.merge(roleToUpdate);
	}

	@Override
	public void deleteRole(Long id) {
		entityManager.remove(entityManager.getReference(Role.class, id));
		
	}

}
