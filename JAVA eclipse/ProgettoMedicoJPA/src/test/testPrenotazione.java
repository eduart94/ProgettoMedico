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
		
		
		EsitoOperazione eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "mal di testa", 3, "eduart94@", "marta88@", 1, 1);
		    assertTrue(eo.isSuccess());
		
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Schiena spezzata", 2, "eduart94@", "franco00@", 2, 1);
			assertTrue(eo.isSuccess());
			
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Braccio rotto", 5, "eduart94@", "luisa66@", 3, 1);
			assertTrue(eo.isSuccess());
				
				
	     eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "mal di denti", 3, "roberto93@", "luigi99@", 4, 2);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "cavoglia rotta", 2, "marco87@", "franco00@", 5, 4);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "denti marci", 6, "francesco84@", "franco00@", 6, 3);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "piede piatto", 5, "francesco84@", "sara77@", 7, 5);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "testa rossa", 3, "eduart94@", "sara77@", 8, 6);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "naso arrossato", 0, "francesco84@", "sara77@", 9, 7);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "non lo so", 5, "eduart94@", "luisa66@", 11, 9);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "sto per morire", 3, "flavio92@", "franco00@", 12, 6);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Influenza", 4, "eduart94@", "sara77@", 13, 5);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Influenza", 2, "flavio92@", "marta88@", 14, 4);
			assertTrue(eo.isSuccess());
		 eo = gp.nuovaPrenotazione(new Date(), new Time(new Date().getTime()), "Influenza", 5, "eduart94@", "franco00@", 15, 3);
			assertTrue(eo.isSuccess());
	}
//	@Test
//	public void TestcancellaPrenotazione() {
//		GestionePrenotazione gp = new GestionePrenotazione();
//		
//		EsitoOperazione eo = gp.cancellaPrenotazione("marta88@", 4);
//		assertTrue(eo.isSuccess());
//	}

}
