package com.aht.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.aht.entitiesrole.Role;
import com.aht.entitiesrole.User;
import com.aht.repositoryrole.RoleRepository;
import com.aht.repositoryrole.UserRepository;
import com.aht.servicerole.UserDetailsServiceImpl;

@Controller
public class MainController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}


	@GetMapping(value = "/register")
	public String registerForm() {
		return "register";
	}

	// dang ky thong tin
	@GetMapping("/registerFrom")
	public String createUser(Model model, @ModelAttribute("user") User user,
	           @RequestParam(value = "password", defaultValue = "a") String password) {
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName("ROLE_MEMBER"));
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(password));
		userDetailsServiceImpl.addUser(user);
		return "login";
	}
	
	@GetMapping(value = "/employeeDetai")
	public String employeeDetai() {
		return "employeeDetai";
	}
}
