package test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;

import gestione.EsitoOperazione;
import gestione.GestionePrenotazione;

public class testPrenotazione {

	@Test
	public void testNuovaPrenotazione() {
		
		GestionePrenotazione gp = new GestionePrenotazione();
		
		
		EsitoOperazione eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "mal di testa", 3, "marco@rossi", "sara77@", 5, 5);
		assertTrue(eo.isSuccess());
	}

}
