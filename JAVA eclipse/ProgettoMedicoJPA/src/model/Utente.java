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
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="cognome", nullable = false)
	private String cognome;

	
	@Column(name="codice_fiscale", nullable = false)
	private String codiceFiscale;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita")
	private Date dataNascita;

	@Column(name="numero_telefono")
	private String numeroTelefono;
	
	private boolean attivo;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="utente")
	@JoinColumn(nullable=false)
	private List<Prenotazione> prenotaziones;
	
	

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Utente() {
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