package com.palma.gestioneeasyvacanza.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="prenotazioni")
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length = 10)
	private Long numeroprenotazione;
	@Column(nullable = false)
	private LocalDate dataprenotazione;
	@Column(nullable = true)
	private Integer numerospiti;
	@Enumerated(EnumType.STRING)
	private StatoPrenotazione stato;
	
	@ManyToOne
    @JoinColumn(name = "id_vacanza")
    private Vacanza vacanza;
	
	//@JsonIgnore
	//@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	//@JoinColumn(name = "id_vacanza")
	//private Vacanza vacanza;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "Prenotazione_Cliente",
			joinColumns = @JoinColumn(name = "id_prenotazione"),
			inverseJoinColumns = @JoinColumn(name = "id_cliente"))
	private List<Cliente> clienti;
}
