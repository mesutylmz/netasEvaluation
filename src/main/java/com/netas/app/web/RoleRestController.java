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
import com.netas.app.service.api.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rolerest")
public class RoleRestController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.GET,value="/roles")
	public ResponseEntity<List<Role>> getUsers(){
		
		List<Role> roles = roleService.findRoles();
		return ResponseEntity.ok(roles);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/role")
	public ResponseEntity<List<Role>> getRoles(@RequestParam("name") String name) {
		List<Role> roles = roleService.findByName(name);
		return ResponseEntity.ok(roles);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/role/new")
	public ResponseEntity<URI> createRole(@RequestBody Role role) {
		try {
			roleService.createRole(role);
			Long id = role.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/role/{id}")
	public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @RequestBody Role roleRequest) {
		try {
			Role role = roleService.findRole(id);
			role.setName(roleRequest.getName());
			roleService.updateRole(role);
			return ResponseEntity.ok().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
