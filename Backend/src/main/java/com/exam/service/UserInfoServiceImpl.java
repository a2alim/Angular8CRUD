package com.exam.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dao.UserInfoDao;
import com.exam.dao.UserInfoDaoImpl;
import com.exam.model.ApplyLoan;
import com.exam.model.Response;
import com.exam.model.UserInfo;

@Service
@Transactional
public class UserInfoServiceImpl implements UserDetailsService,UserInfoService {
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	UserInfoDaoImpl userInfoDaoImpl;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo entity = userInfoDao.loadUserByUsername(username);
		return new org.springframework.security.core.userdetails.User(entity.getUsername(), entity.getPassword(), getAuthorities(entity));
	}
	
	private Collection<GrantedAuthority> getAuthorities(UserInfo entity){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities = AuthorityUtils.createAuthorityList(entity.getRole());
		return authorities;
		
	}
	
	public UserInfo getUserByEmail(String email, String password) {
		
		return userInfoDao.getUserByEmail(email, password);
	}

	@Override
	public UserInfo save(UserInfo entity) {
		return userInfoDao.save(entity);
	}

	public Response saveEmp(UserInfo entity) {
		return userInfoDaoImpl.saveEmp(entity);
	}
	
	@Override
	public UserInfo update(UserInfo entity) {		
		return userInfoDao.update(entity);
	}

	@Override
	public boolean delete(long id) {
		return userInfoDao.delete(id);
	}

	@Override
	public UserInfo getById(long id) {
		return userInfoDao.getById(id);
	}
	
	@Override
	public List<UserInfo> getByUsername(String user) {
		return userInfoDao.getByUsername(user);
	}

	@Override
	public List<UserInfo> getAll() {
		return userInfoDao.getAll();
	}

	@Override
	public ApplyLoan update(ApplyLoan entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
