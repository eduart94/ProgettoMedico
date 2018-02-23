package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import gestione.EsitoOperazione;
import gestione.GestioneAccountMedico;

public class TestAccountMedico {

	@Test
	public void testRegistrazione() {
		GestioneAccountMedico gam = new GestioneAccountMedico(); 
		EsitoOperazione eo = gam.registraMedico("eduart94@", "ciao1", "eduart", "blu", new Date(1994-03-03) , "123456789", "oculista");
		assertTrue(eo.isSuccess());
		
		eo = gam.registraMedico("flavio92@", "ciao2", "flavio", "verdi", new Date(1995-03-03) , "66666789", "dermatologo");
		assertTrue(eo.isSuccess());
		
		eo = gam.registraMedico("francesco84@", "ciao3", "francesco", "arancione", new Date(1996-03-03) , "44446789", "cardiologo");
		assertTrue(eo.isSuccess());
		
		eo = gam.registraMedico("marco87@", "ciao4", "marco", "rossi", new Date(1997-03-03) , "333456789", "pediatra");
		assertTrue(eo.isSuccess());
		
		eo = gam.registraMedico("roberto94@", "ciao5", "roberto", "bianchi", new Date(1998-03-03) , "888456789", "chirurgo");
		assertTrue(eo.isSuccess());
	   
		eo = gam.registraMedico("roberto93@", "ciao5", "roberto", "bianchi",  new Date(1998-03-03) , "888456789", "chirurgo");
		assertTrue(eo.isSuccess());
		
	}
	
	@Test
	public void testRimuovi() {
		GestioneAccountMedico gam = new GestioneAccountMedico(); 
		EsitoOperazione eo = gam.rimuoviMedico("roberto93@");
		assertFalse(eo.isSuccess());
	}
	
	@Test
	public void testLogin() {
		GestioneAccountMedico gam = new GestioneAccountMedico(); 
		EsitoOperazione eo = gam.login("roberto94@", "ciao5");
		assertTrue(eo.isSuccess());
		
		eo = gam.login("roberto94@", "ciaoy");
		assertFalse(eo.isSuccess());
		
		eo = gam.login("roberto@", "ciao5");
		assertFalse(eo.isSuccess());
		
	}
	
	

}
