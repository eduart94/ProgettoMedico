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
		
		
		EsitoOperazione eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "mal di testa", 3, "eduart94@", "marta88@", 6, 1);
		    assertTrue(eo.isSuccess());
		
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Schiena spezzata", 2, "eduart94@", "franco00@", 7, 1);
			assertTrue(eo.isSuccess());
			
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Braccio rotto", 5, "eduart94@", "luisa66@", 8, 1);
			assertTrue(eo.isSuccess());
				
				
	     eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Influenza", 5, "eduart94@", "sara77@", 9, 1);
			assertTrue(eo.isSuccess());
	}

}
