package licodipo.controller;

import java.util.List;

import licodipo.dao.UserDao;
import licodipo.model.UserApp;

public class UserControllerImpl implements UserController{
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserApp findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserApp> getUsers() {
		List<UserApp> list = userDao.findAllUsers();
		return list;
	}

	@Override
	public void addUser(UserApp userApp) {
		userDao.addUser(userApp);
		
	}
	
	
}
