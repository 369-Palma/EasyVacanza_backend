package com.palma.gestioneeasyvacanza.runner;

import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.palma.gestioneeasyvacanza.model.Prenotazione;

import com.palma.gestioneeasyvacanza.auth.entity.ERole;
import com.palma.gestioneeasyvacanza.auth.entity.Role;
import com.palma.gestioneeasyvacanza.auth.repository.RoleRepository;
import com.palma.gestioneeasyvacanza.auth.repository.UserRepository;
import com.palma.gestioneeasyvacanza.auth.service.AuthService;
import com.palma.gestioneeasyvacanza.service.AttivitaService;
import com.palma.gestioneeasyvacanza.service.ClienteService;
import com.palma.gestioneeasyvacanza.service.VacanzaService;
import com.palma.gestioneeasyvacanza.service.PrenotazioneService;
import com.palma.gestioneeasyvacanza.service.TestimonianzaService;

@Component
public class EasyVacanzaRunner implements ApplicationRunner {

	@Autowired ClienteService clienteService;
	@Autowired AttivitaService attivitaService;
	@Autowired VacanzaService vacanzaService;
	@Autowired PrenotazioneService prenotazioneService;
	@Autowired TestimonianzaService testimonianzaService;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthService authService;
	

	private static Set<Role> adminRole;
	private static Set<Role> userRole;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run ...");
		
		//SETTA RUOLI ADMIN/USER IN DB
		//setRoleDefault();
		
		//EFETTUARE LA REGISTRAZIONE E IL LOGIN
		
		//REGISTRARSI QUI TRAMITE ENDPOINT
		//POPOLA IL DB
		//starterDB();
	
		
	}
	
	private void starterDB() {
		
		//genera ATTIVITA'
		for (int i = 0; i<10; i++) {	
			attivitaService.createAttivitaRandom();
		}
		
		//genera CLIENTE
		for (int i = 0; i<5; i++) {
		clienteService.createClienteRandom();
		}
	
		//genera TESTIMONIANZA
		for (int i = 0; i<30; i++) {
			testimonianzaService.createTestimonianzaRandom();
		}
			
		//genera VACANZA
		for (int i = 0; i<30; i++) {
			vacanzaService.createVacanzaRandom();
		}
		
		//genera PRENOTAZIONE
		for (int i = 0; i<5; i++) {
			prenotazioneService.createPrenotazioneRandom();
		}

	}
		
	Prenotazione p = new Prenotazione();
		
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(user);

		userRole = new HashSet<Role>();
		userRole.add(user);
	}

}
