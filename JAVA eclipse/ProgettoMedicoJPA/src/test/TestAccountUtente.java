package test;

import static org.junit.Assert.*;

import java.sql.Date;


import org.junit.Test;

import gestione.EsitoOperazione;
import gestione.GestioneAccountUtente;

public class TestAccountUtente {
	
	@Test
	public void testRegistrazione() {
		GestioneAccountUtente gau = new GestioneAccountUtente();
		EsitoOperazione eo = gau.registraUtente("franco00@", "password1", "franco", "machi", new Date(2000-12-12), "123456");
		assertFalse(eo.isSuccess());
		
		eo = gau.registraUtente("luigi99@", "password4", "luigi", "miti",  new Date(2000-12-12), "123456");
		assertTrue(eo.isSuccess());
		
		eo = gau.registraUtente("luisa66@", "password2", "luisa", "raci", new Date(2008-12-12), "78956");
		assertTrue(eo.isSuccess());

		eo = gau.registraUtente("marta88@", "password3", "marta", "saci", new Date(2005-12-12), "134556");
		assertTrue(eo.isSuccess());
		
		eo = gau.registraUtente("sara77@", "password5", "sara", "segul", new Date(2002-12-12), "098756");
		assertTrue(eo.isSuccess());
	}
	
	@Test
	public void testRimuovi() {
		GestioneAccountUtente gau = new GestioneAccountUtente();
		EsitoOperazione eo = gau.rimuoviUtente("paola@");
		assertTrue(eo.isSuccess());
		
		eo = gau.rimuoviUtente("eddi@");
		assertFalse(eo.isSuccess());
		
	}

	@Test
	public void testLogin() {
		GestioneAccountUtente gau = new GestioneAccountUtente();
		EsitoOperazione eo = gau.login("luigi99@", "ciao");
		assertFalse(eo.isSuccess());
		
		eo = gau.login("luigi99@", "password4");
		assertTrue(eo.isSuccess());
		
		eo = gau.login("luigi99", "password4");
		assertFalse(eo.isSuccess());
		
	}
	
	

}
