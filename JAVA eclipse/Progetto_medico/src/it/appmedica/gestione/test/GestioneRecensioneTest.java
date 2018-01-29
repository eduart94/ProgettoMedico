package it.appmedica.gestione.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.appmedica.gestione.GestioneRecensione;
import it.appmedica.model.Prenotazione;

public class GestioneRecensioneTest {

	@Test
	public void test() {
	
		GestioneRecensione gp = new GestioneRecensione();
		Prenotazione p = new Prenotazione();
		p.setIdPrenotazione(1);
		gp.aggiungiRecensione(p, 3);	
	
	}

}
