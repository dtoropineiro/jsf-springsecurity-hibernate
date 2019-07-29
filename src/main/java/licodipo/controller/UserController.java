package licodipo.controller;

import java.util.List;

import licodipo.model.UserApp;

public interface UserController {
	UserApp findByUserName(String username);
	List<UserApp> getUsers();
	void addUser(UserApp userApp);
}
