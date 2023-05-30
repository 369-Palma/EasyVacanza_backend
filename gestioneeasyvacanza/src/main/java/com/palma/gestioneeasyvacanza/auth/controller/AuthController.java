package com.palma.gestioneeasyvacanza.auth.controller;

import com.palma.gestioneeasyvacanza.auth.payload.JWTAuthResponse;
import com.palma.gestioneeasyvacanza.auth.payload.LoginDto;
import com.palma.gestioneeasyvacanza.auth.payload.RegisterDto;
import com.palma.gestioneeasyvacanza.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//@CrossOrigin(origins = "*", maxAge = 360000)
@RequestMapping("/api/auth")
public class AuthController {

  private AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  // Build Login REST API
  @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
  @PostMapping(value = { "/login", "/signin" })
  public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) {
    String token = authService.login(loginDto);

    JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
    jwtAuthResponse.setUsername(loginDto.getUsername());
    jwtAuthResponse.setAccessToken(token);

    return ResponseEntity.ok(jwtAuthResponse);
  }

  // Build Register REST API

  @PostMapping(value = { "/register", "/signup" })
  public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
    String response = authService.register(registerDto);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
}
