package com.netas.app.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import com.netas.app.dao.api.RoleRepository;
import com.netas.app.dao.api.UserRepository;
import com.netas.app.model.Role;
import com.netas.app.model.User;
import com.netas.app.service.api.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public List<Role> findRoles() {
		return roleRepository.getAll();
	}

	@Override
	public List<Role> findByName(String name) {
		return roleRepository.getByName(name);
	}

	@Override
	public Role findRole(Long id) {
		return roleRepository.getById(id);
	}
	@Transactional
	@Override
	public void createRole(Role role) {
		roleRepository.createRole(role);	
	}
	
	@Transactional
	@Override
	public void updateRole(Role role) {
		roleRepository.updateRole(role);
		
	}

	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteRole(id);
	}

}
