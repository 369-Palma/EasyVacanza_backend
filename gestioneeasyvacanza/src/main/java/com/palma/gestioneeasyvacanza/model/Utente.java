package com.palma.gestioneeasyvacanza.model;

import com.palma.gestioneeasyvacanza.auth.entity.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
public class Utente extends User {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer age;
}
