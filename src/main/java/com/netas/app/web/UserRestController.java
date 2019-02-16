package com.netas.app.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.netas.app.model.Role;
import com.netas.app.model.User;
import com.netas.app.service.api.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/userrest")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET,value="/users")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> users = userService.findUsers();
		return ResponseEntity.ok(users);
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id){
		
		User user = userService.findUser(id);
		return ResponseEntity.ok(user);
			
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public ResponseEntity<List<User>> getOwners(@RequestParam("name") String name) {
		List<User> users 	= userService.findByName(name);
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/new")
	public ResponseEntity<URI> createRole(@RequestBody User user) {
		try {
			userService.createUser(user);
			Long id = user.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
	public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody User userRequest) {
		try {
			User user = userService.findUser(id);
			user.setName(userRequest.getName());
			userService.updateUser(user);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
