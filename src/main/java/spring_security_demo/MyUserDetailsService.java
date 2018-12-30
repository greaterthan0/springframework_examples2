package spring_security_demo;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=new User();
		user.setUsername("admin");
		user.setPassword("111");
		user.setId(11);
		
		UserBuilder builder=org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
		
        builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
        
        builder.roles(new String [] {});

        return builder.build();
	}
}