package com.netas.app.dao.api;

import java.util.List;

import com.netas.app.model.User;

public interface UserRepository {
	
	List<User> 	getAll			();
	User 		getById			(Long id);
	List<User>	getByName		(String name);
	List<User>  getByPhoneNumber(String phoneNumber);
	
	void 		createUser 		(User userToCreate);
	User		updateUser		(User userToUpdate);
	void		deleteuser		(Long id);
 
}
