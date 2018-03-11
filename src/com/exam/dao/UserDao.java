package com.exam.dao;

import java.util.List;

import com.exam.model.User;

public interface UserDao {
	
	public List<User> listUsers();	
	public void saveUser(User user );
	public List<User> getUserByUserEmail(String userEmail);
	public List<User> validateLoginUser(String userEmail,String password);
}
