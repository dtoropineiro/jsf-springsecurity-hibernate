package licodipo.model;

import java.util.HashSet;
import java.util.Set;

public class UserApp {
	private String userName;
	private String password;
	private boolean enabled;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	//private UserRole userRole;
	
	public UserApp() {
		
	}
	
//	public UserRole getUserRole() {
//		return userRole;
//	}
//
//	public void setUserRole(UserRole userRole) {
//		this.userRole = userRole;
//	}

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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	
	
}
