package com.palma.gestioneeasyvacanza.model;

import java.time.LocalDate;
import java.util.List;

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
	@Column(nullable = false)
	private Integer numerospiti;
	@Enumerated(EnumType.STRING)
	private StatoPrenotazione stato;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_vacanza")
	private Vacanza vacanza;
	
	@ManyToMany
	@JoinTable(name = "Prenotazione_Cliente",
			joinColumns = @JoinColumn(name = "id_prenotazione"),
			inverseJoinColumns = @JoinColumn(name = "id_cliente"))
	private List<Cliente> clienti;
}
