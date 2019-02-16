package com.netas.app.dao.api;

import java.util.List;

import com.netas.app.model.Role;

public interface RoleRepository {
	List<Role> 	getAll();
	Role 		getById	(Long id);
	List<Role>	getByName(String name);
	
	void 		createRole 	(Role roleToCreate);
	Role		updateRole	(Role roleToUpdate);
	void		deleteRole	(Long id);
}
