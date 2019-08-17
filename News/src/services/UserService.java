package services;

import dao.IUserDao;
import models.User;

public class UserService implements IUserServise{

	IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User connect(User user) {
		return userDao.connect(user);
	}

	
	@Override
	public User find(String username) {
		return userDao.find(username);
	}

}
