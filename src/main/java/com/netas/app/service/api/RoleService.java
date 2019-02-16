package com.netas.app.service.api;

import java.util.List;

import com.netas.app.model.Role;
import com.netas.app.model.User;

public interface RoleService {
	List<Role> 	findRoles			();
	List<Role> 	findByName			(String name);
	
	Role		findRole	(Long id);
	void 		createRole	(Role role);
	void		updateRole	(Role role);
	void		deleteRole	(Long id);
}
