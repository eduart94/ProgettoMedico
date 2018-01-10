import java.util.Date;

public class Utente {

private int idUtente;
private String nome_utente;
private String cognome_utente;
private Date data_Nascita_utente;
private String codice_fiscale_utente;
private String numero_telefono_utente;
private String email_utente;
private String username_utente;
private String password_utente;

public int getIdUtente() {
	return idUtente;
}
public void setIdUtente(int idUtente) {
	this.idUtente = idUtente;
}
public String getNome_utente() {
	return nome_utente;
}
public void setNome_utente(String nome_utente) {
	this.nome_utente = nome_utente;
}
public String getCognome_utente() {
	return cognome_utente;
}
public void setCognome_utente(String cognome_utente) {
	this.cognome_utente = cognome_utente;
}
public Date getData_Nascita_utente() {
	return data_Nascita_utente;
}
public void setData_Nascita_utente(Date data_Nascita_utente) {
	this.data_Nascita_utente = data_Nascita_utente;
}
public String getCodice_fiscale_utente() {
	return codice_fiscale_utente;
}
public void setCodice_fiscale_utente(String codice_fiscale_utente) {
	this.codice_fiscale_utente = codice_fiscale_utente;
}
public String getNumero_telefono_utente() {
	return numero_telefono_utente;
}
public void setNumero_telefono_utente(String numero_telefono_utente) {
	this.numero_telefono_utente = numero_telefono_utente;
}
public String getEmail_utente() {
	return email_utente;
}
public void setEmail_utente(String email_utente) {
	this.email_utente = email_utente;
}
public String getUsername_utente() {
	return username_utente;
}
public void setUsername_utente(String username_utente) {
	this.username_utente = username_utente;
}
public String getPassword_utente() {
	return password_utente;
}
public void setPassword_utente(String password_utente) {
	this.password_utente = password_utente;
}

}