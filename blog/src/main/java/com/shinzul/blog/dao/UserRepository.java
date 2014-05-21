package com.shinzul.blog.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shinzul.blog.entity.User;

public interface UserRepository extends CrudRepository<User, BigInteger>{

	public User findByUsername(String username);
	
	public List<User> findByEmail(String email);

	public void delete(BigInteger id);
	
}
