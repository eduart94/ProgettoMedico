package model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUtente;
	
	@Column(name="username_utente", nullable = false)
	private String usernameUtente;
	
	@Column(name="email_utente", nullable = false)
	private String emailUtente;
	
	@Column(name="password_utente", nullable = false)
	private String passwordUtente;
	
	@Column(name="nome_utente", nullable = false)
	private String nomeUtente;
	
	@Column(name="cognome_utente", nullable = false)
	private String cognomeUtente;

	@Column(name="codice_fiscale_utente", nullable = false)
	private String codiceFiscaleUtente;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita_utente")
	private Date dataNascitaUtente;

	@Column(name="numero_telefono_utente")
	private String numeroTelefonoUtente;

	
	
	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="utente")
	@JoinColumn(nullable=false)
	private List<Prenotazione> prenotaziones;
	
	private boolean attivo;

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public Utente() {
	}
	public Utente(String email, String password) {
		this.email = email;
		this.password = password;
		
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCodiceFiscaleUtente() {
		return this.codiceFiscaleUtente;
	}

	public void setCodiceFiscaleUtente(String codiceFiscaleUtente) {
		this.codiceFiscaleUtente = codiceFiscaleUtente;
	}

	public String getCognomeUtente() {
		return this.cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public Date getDataNascitaUtente() {
		return this.dataNascitaUtente;
	}

	public void setDataNascitaUtente(Date dataNascitaUtente) {
		this.dataNascitaUtente = dataNascitaUtente;
	}

	public String getEmailUtente() {
		return this.emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getNomeUtente() {
		return this.nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getNumeroTelefonoUtente() {
		return this.numeroTelefonoUtente;
	}

	public void setNumeroTelefonoUtente(String numeroTelefonoUtente) {
		this.numeroTelefonoUtente = numeroTelefonoUtente;
	}

	public String getPasswordUtente() {
		return this.passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}

	public String getUsernameUtente() {
		return this.usernameUtente;
	}

	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setUtente(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setUtente(null);

		return prenotazione;
	}

}