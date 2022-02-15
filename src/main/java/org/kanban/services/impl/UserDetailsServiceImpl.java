package org.kanban.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.kanban.entities.Usuario;
import org.kanban.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario appUser = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		return this.userBuilder(appUser.getUsername(), 
				appUser.getPassword(), 
				appUser.getRole());
	}

	public User userBuilder(String username, String password, String... roles) {
		boolean enabled=true;
		boolean accountNonExpired =true;
		boolean accountNonLocked =true;
		boolean credentialsNonExpired=true;
		List<GrantedAuthority> autorithies = new ArrayList<>();
		for(String role : roles) {
			autorithies.add(new SimpleGrantedAuthority("ROLE_"+role));
		}
	 return new User(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,autorithies);
	}

}
