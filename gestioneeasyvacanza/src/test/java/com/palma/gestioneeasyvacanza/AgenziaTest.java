package com.palma.gestioneeasyvacanza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.palma.gestioneeasyvacanza.model.Attivita;
import com.palma.gestioneeasyvacanza.model.Cliente;
import com.palma.gestioneeasyvacanza.model.Difficolta;
import com.palma.gestioneeasyvacanza.model.Preferenze;
import com.palma.gestioneeasyvacanza.model.Prenotazione;
import com.palma.gestioneeasyvacanza.model.StatoPrenotazione;
import com.palma.gestioneeasyvacanza.model.Testimonianza;
import com.palma.gestioneeasyvacanza.model.TipoAlloggio;
import com.palma.gestioneeasyvacanza.model.TipoAttivita;
import com.palma.gestioneeasyvacanza.model.TipologiaLuogo;
import com.palma.gestioneeasyvacanza.model.Vacanza;

public class AgenziaTest {

	static Attivita a;
	static Cliente c;
	static Testimonianza t;
	static Vacanza v;
	static Prenotazione p;
	
	@BeforeAll
	public static void beforeTest() {
		
		List<Prenotazione> listP = new ArrayList<>();
		listP.add(p);
		
		t = new Testimonianza(5l,"nome","cognome","email","commento",4,a,c);
		List<Testimonianza> testL= new ArrayList<>();
		testL.add(t);
		
		List<Vacanza> listaV = new ArrayList<>();
		listaV.add(v);
		
		a = new Attivita(3l,TipoAttivita.Arrampicata, "descrizione", Difficolta.AVANZATO, listaV, testL);
		List<Attivita> attivitaL = new ArrayList<>();
		attivitaL.add(a);
		
		c = new Cliente(2l,"nome","cognome","email",30,listP,testL);		
		List<Cliente> clienteL = new ArrayList<>();
		clienteL.add(c);
		
		v = new Vacanza(23l,"Bari","indirizzo", "bellissimo",TipologiaLuogo.CAMPAGNA,"immagineurl", "3 giorni", LocalDate.of(2022, 5, 12),LocalDate.of(2022, 5, 15),TipoAlloggio.CAMPEGGIO_ATTREZZATO,Preferenze.ACCESSIBILITA_DISABILI,101d,attivitaL,p);

		p = new Prenotazione(0l,3829374938l, LocalDate.of(2022, 5, 12), 2, StatoPrenotazione.CONFERMATO,v,clienteL);
	}
	
	@Test
	@DisplayName("durata giorni")
	public void testDataFine() {
		assertEquals(v.getDatainizio().plusDays(3), v.getDatafine());
	}
	
	@Test
	@DisplayName("tipologia luogo")	
	public void testTipoLuogo () {
		assertEquals(TipologiaLuogo.CAMPAGNA, v.getTipoluogo());
	}
	
	@Test
	@DisplayName("tipo di alloggio")	
	public void testTipoAlloggio () {
		assertEquals(TipoAlloggio.CAMPEGGIO_ATTREZZATO, v.getAlloggio());
	}
	
	@Test
	@DisplayName("preferenze")	
	public void testPreferenza () {
		assertEquals(Preferenze.ACCESSIBILITA_DISABILI, v.getPreferenza());
	}
	
	@Test
	@DisplayName("tipologia di attività")
	public void testTipoAttivita() {
		assertEquals(TipoAttivita.Arrampicata, a.getAttivita());
	}
	
	
	@Test
	@DisplayName("livello di difficoltà")	
	public void testLivello () {
		assertEquals(Difficolta.AVANZATO, a.getDifficolta());
	}
	
	@Test
	@DisplayName("stato della prenotazione")	
	public void testStatoPrenotazione () {
		assertEquals(StatoPrenotazione.CONFERMATO, p.getStato());
	}
	
	@AfterAll
	public static void afterTest() {
		p = null;
		v = null;
		t = null;
		c = null;
		a = null;
	}
	
}
