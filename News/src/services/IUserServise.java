package services;

import models.User;

import org.springframework.transaction.annotation.Transactional;

public interface IUserServise {

	@Transactional
	public User connect(User user);
	
	@Transactional
	public User find(String username);
}
