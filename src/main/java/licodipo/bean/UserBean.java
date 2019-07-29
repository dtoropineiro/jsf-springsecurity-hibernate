package licodipo.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import licodipo.controller.UserController;
import licodipo.model.UserApp;
import licodipo.model.UserRole;

public class UserBean {
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	private String userName;
	private String password;
	private UserRole userRole;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	UserController userController;

	
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public String addUser() {
		try {
			UserApp user = new UserApp();
			user.setUserName(getUserName());
			 String hashedPassword = passwordEncoder.encode(getPassword());
			user.setPassword(hashedPassword);
			getUserController().addUser(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		FacesContext.getCurrentInstance().addMessage("myForm:password1", new FacesMessage("Password Doesnt Match"));
		return ERROR;
	}
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserController getUserController() {
		return userController;
	}



	public void setUserController(UserController userController) {
		this.userController = userController;
	}



	public String login() {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext extenalContext = facesContext.getExternalContext();
	    RequestDispatcher dispatcher = ((ServletRequest)extenalContext.getRequest()).getRequestDispatcher("/j_spring_security_check");
	    try {
			dispatcher.forward((ServletRequest)extenalContext.getRequest(), (ServletResponse)extenalContext.getResponse());
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    facesContext.responseComplete();
	    return null;
	}
}
