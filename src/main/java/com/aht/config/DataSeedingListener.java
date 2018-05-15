package com.aht.config;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aht.entitiesrole.Role;
import com.aht.entitiesrole.User;
import com.aht.repositoryrole.RoleRepository;
import com.aht.repositoryrole.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}

		if (roleRepository.findByName("ROLE_MEMBER") == null) {
			roleRepository.save(new Role("ROLE_MEMBER"));
		}

		// Admin account
		if (userRepository.findByEmail("admin@gmail.com") == null) {
			User admin = new User();
			admin.setName("admin");
			admin.setEmail("admin@gmail.com");
			admin.setPassword(passwordEncoder.encode("123456"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_ADMIN"));
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}

		// Member account
		if (userRepository.findByEmail("hoi@gmail.com") == null) {
			User user1 = new User();
			user1.setName("hoi");
			user1.setEmail("hoi@gmail.com");
			user1.setPassword(passwordEncoder.encode("123456"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			user1.setRoles(roles);
			userRepository.save(user1);
		}

	}

	
	

}
