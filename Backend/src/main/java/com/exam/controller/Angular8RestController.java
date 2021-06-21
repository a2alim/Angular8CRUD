package com.exam.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Response;
import com.exam.model.UserInfo;
import com.exam.service.ContactServiceImpl;
import com.exam.service.UserInfoService;
import com.exam.service.UserInfoServiceImpl;

@SpringBootApplication
@RestController
@RequestMapping("")
@CrossOrigin("*")
public class Angular8RestController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ContactServiceImpl contactServiceImpl;
	
	@Autowired
	UserInfoService userInfoService;
	

	@Autowired
	UserInfoServiceImpl userInfoServiceImpl;
	
	
	@PostMapping(value = "/save-ms-user")
	public Response saveEmp(@RequestBody UserInfo entity) {
		
		String pass = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(pass));
		entity.setRole("User");
		entity.setCreatedDate(new Date());
		
		return userInfoServiceImpl.saveEmp(entity);
		
	}
	
	@PostMapping(value = "/save-user")
	public String save(@RequestBody UserInfo entity) {
		
		String pass = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(pass));
		entity.setRole("User");
		entity.setCreatedDate(new Date());
		userInfoService.save(entity);
		
		return "Hi "+ entity.getUsername() +" Your's registration completed.";
		
	}
	
	@DeleteMapping("/delete-ms-user/{id}")
	public Response deleteUserInfo(@PathVariable long id) {
		
		 userInfoService.delete(id);
		 Response rs = new Response();
		 rs.setMessage("Delete Successfull !");
		 return rs;
	}

	@GetMapping("/show-ms-user-by-username/{userName}")
	public List<UserInfo> getUserByUsername(@PathVariable String userName){
		 List<UserInfo> entity = userInfoService.getByUsername(userName);
		
		return entity;
	}
	
	@GetMapping("/show-ms-user-by/{id}")
	public UserInfo getUserById(@PathVariable("id") long id){
		 UserInfo entity = userInfoService.getById(id);
		
		return entity;
	}

	@GetMapping("/show-ms-user")
	public List<UserInfo> showUserInfo(){
		
		List<UserInfo> user = userInfoService.getAll();
		return user;
		
	}
	
	@PostMapping(value = "/update-ms-user")
	public Response updateUser(@RequestBody UserInfo entity) {
			
		UserInfo en = userInfoService.getById(entity.getUserId());
		Response rs = new Response();
		if(en != null) {
			entity.setUpdateDate(new Date());
			entity.setFirstName(entity.getFirstName());
			userInfoService.update(entity);
			rs.setMessage("Hi "+ en.getUsername() +" Your's update is completed.");
		}
		
		return rs;
		
	}

}
