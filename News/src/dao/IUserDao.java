package dao;

import models.User;

public interface IUserDao {

	public User connect(User user);
	
	public User find(String username);
}
