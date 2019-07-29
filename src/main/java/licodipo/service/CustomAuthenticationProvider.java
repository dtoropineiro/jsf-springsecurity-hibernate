package licodipo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import licodipo.dao.UserDao;
import licodipo.model.UserApp;




public class CustomAuthenticationProvider implements AuthenticationProvider {
  private Logger log = Logger.getLogger(this.getClass().getName());
  	
  private UserDao userDao;

  public UserDao getUserDao() {
		return userDao;
  }

  public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
  }
	static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    UserApp user = userDao.findByUserName(username);
    
    if (user == null) {
      log.info("username not found " + username);
      throw new SecurityExecption("user " + username + "");
    }
    if (!passwordEncoder.matches(password, user.getPassword())) {
      log.info("invalid passpord for " + username);
      throw new BadCredentialsException("denied user " + username);
    }
    String role = userDao.findRoleByUserName(username);

    Collection<? extends GrantedAuthority> authorities =  getAuthorities(role);


    return new UsernamePasswordAuthenticationToken(username, password, authorities);

  }

  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

  public Collection<? extends GrantedAuthority> getAuthorities(String role) {
	  
      List<GrantedAuthority> authList = getGrantedAuthorities(role);
      return authList;
  }
  public static List<GrantedAuthority> getGrantedAuthorities(String role) {
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       
	authorities.add(new SimpleGrantedAuthority(role));
	return authorities;
  }

}
