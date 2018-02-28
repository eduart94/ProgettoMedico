package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gestione.EsitoOperazione;
import gestione.GestionePrenotazione;
import model.Prenotazione;
import model.Utente;

public class TestPrenotazione {

	@Test
	public void test() {
	  GestionePrenotazione gp = new GestionePrenotazione();
	  Utente u = new Utente("franco00@", "password1");
	  Prenotazione p = new Prenotazione(1);
	  EsitoOperazione eo = gp.cancellaPrenotazione(u, p);
	  assertTrue(eo.isSuccess());
	}

}
