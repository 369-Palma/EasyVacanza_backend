package com.palma.gestioneeasyvacanza.auth.service;

import com.palma.gestioneeasyvacanza.auth.payload.LoginDto;
import com.palma.gestioneeasyvacanza.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
