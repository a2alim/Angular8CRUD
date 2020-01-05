package com.exam.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.commerz.Utility.ParameterBuilder;
import com.exam.model.ApplyLoan;
import com.exam.model.Contact;
import com.exam.model.Installment;
import com.exam.model.UserInfo;
import com.exam.service.ApplyLoanServiceImpl;
import com.exam.service.ContactServiceImpl;
import com.exam.service.InstallmentServiceImpl;
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
	
	
	
	@PostMapping(value = "/save-ms-user")
	public String save(@RequestBody UserInfo entity) {
		
		System.out.println("Save UserInfo::::::::::"+entity);
		
		String pass = entity.getPassword();
		entity.setPassword(passwordEncoder.encode(pass));
		entity.setRole("User");
		entity.setCreatedDate(new Date());
		userInfoService.save(entity);
		
		return "Hi "+ entity.getUsername() +" Your's registration completed.";
		
	}
	
	@GetMapping("/delete-ms-user/{id}")
	public List<UserInfo> deleteUserInfo(@PathVariable long id) {
		
		 userInfoService.delete(id);
		 List<UserInfo> user = userInfoService.getAll();
		 return user;
	}

	@GetMapping("/show-ms-user-by-username/{userName}")
	public List<UserInfo> getUserByUsername(@PathVariable String userName){
		System.out.println(userName+"::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		 List<UserInfo> entity = userInfoService.getByUsername(userName);
		
		return entity;
	}
	
	@GetMapping("/show-ms-user-by/{id}")
	public UserInfo getUserById(@PathVariable("id") long id){
		System.out.println(id+"::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		 UserInfo entity = userInfoService.getById(id);
		
		return entity;
	}

	@GetMapping("/show-ms-user")
	public List<UserInfo> showUserInfo(){
		
		List<UserInfo> user = userInfoService.getAll();
		System.out.println(user+":::::::::::::::::::::::::::::::::::::::::::::::::::::");
		return user;
		
	}
	
	@PostMapping(value = "/update-ms-user/{id}")
	public String updateUser(@RequestBody UserInfo entity, @PathVariable("id") long id) {
		
		System.out.println("Save UserInfo::::::::::"+entity);
		
			
		UserInfo en = userInfoService.getById(id);
		
		en.setUpdateDate(new Date());
		en.setFirstName(entity.getFirstName());
		userInfoService.update(en);
		
		return "Hi "+ en.getUsername() +" Your's update is completed.";
		
	}

}
