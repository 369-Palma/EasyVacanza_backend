package com.palma.gestioneeasyvacanza.auth.payload;

import java.util.Set;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
 // Per registrare tutti come USER di Default commentare roles
    private Set<String> roles;
}
