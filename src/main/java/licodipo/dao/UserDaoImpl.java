package licodipo.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import licodipo.model.UserApp;
import licodipo.model.UserRole;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public static HashMap<String, UserApp> hashUser = new HashMap<>();
	public static HashMap<String, UserRole> hashUserRole = new HashMap<>();
	public List<UserApp> findAllUsers(){
		@SuppressWarnings("unchecked")
		List<UserApp> list = getHibernateTemplate().find("from UserApp");
		for (Iterator<UserRole> it = list.get(0).getUserRole().iterator(); it.hasNext(); ) {
	        UserRole userRole = it.next();
	        hashUserRole.put(userRole.getUserName(), userRole);
	    }
		
		for (UserApp u : list) { 
            hashUser.put(u.getUserName(), u);
      	  	
        } 
		return list;
	}

	@Override
	public UserApp findByUserName(String username) {
		findAllUsers();
		UserApp user = hashUser.get(username);
		return user;
	}

	@Override
	public String findRoleByUserName(String username) {
		UserRole userRole = hashUserRole.get(username);
		String role = userRole.getRole();
		return role;
	}

	@Override
	public void addUser(UserApp user) {
		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_ADMIN");
		userRole.setUser(user);
		userRole.setUserName(user.getUserName());
		hashUser.put(user.getUserName(), user); 
		hashUserRole.put(user.getUserName(), userRole);
		getHibernateTemplate().save(user);
		getHibernateTemplate().save(userRole);
		
	}

	

}
