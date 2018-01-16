package it.appmedica.gestione.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.appmedica.gestione.GestioneAccount;

public class GestioneAccountTest {

	@Test
	public void testLogin() {
		GestioneAccount ga = new GestioneAccount();
		
		boolean esito = ga.login("ko", "ko");
		assertFalse("Login errato in errore", esito);
		
		esito = ga.login("ok", "ok");
		assertTrue("Login corretto (username) in errore", esito);
		
		esito = ga.login("ok@test", "ok");
		assertTrue("Login corretto (mail) in errore", esito);	
		
		esito = ga.login("ok", "ko");
		assertFalse("Login errato in errore", esito);	
		
		esito = ga.login("ok@test", "ko");
		assertFalse("Login errato in errore", esito);	
		
	}
	@Test
	public void testRegistrazioneUtente() {
		
		GestioneAccount ga = new GestioneAccount();
		
		boolean esito = ga.registrazioneUtente("", "", "", "", "ok@test", "oktr", "oky");
		assertFalse("esito registrazione errato(email gia esistente)", esito);
		
		esito = ga.registrazioneUtente("", "", "", "", "ok@testfg", "ok", "oky");
		assertFalse("esito registrazione errato(username gia esistente)", esito);
		
		esito = ga.registrazioneUtente("", "", "", "", "ok@test", "ok", "oky");
		assertFalse("esito registrazione errato(email e username gia esistente)", esito);
		
		esito = ga.registrazioneUtente("", "", "", "", "mario@rossi", "mario", "oky");
		assertFalse("esito registrazione errato(username gia esistente)", esito);
		
		
		
		}

}
