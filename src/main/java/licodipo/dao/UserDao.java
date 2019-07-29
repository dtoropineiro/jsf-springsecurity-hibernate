package licodipo.dao;

import java.util.List;

import licodipo.model.UserApp;

public interface UserDao {
	UserApp findByUserName(String username);
	List<UserApp> findAllUsers();
	String findRoleByUserName(String username);
	void addUser(UserApp user);
}
