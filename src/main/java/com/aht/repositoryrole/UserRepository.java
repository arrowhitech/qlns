package com.aht.repositoryrole;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aht.entitiesrole.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
}
