package com.sun.fe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sun.fe.model.User;

@Mapper
public interface UserMapper {
	
	List<User> findAll();
	
	// username used as id
	User findUserById(String username);
	
	void userAdd(User user);

}
