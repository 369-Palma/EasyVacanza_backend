package com.palma.gestioneeasyvacanza.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palma.gestioneeasyvacanza.auth.entity.ERole;
import com.palma.gestioneeasyvacanza.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
