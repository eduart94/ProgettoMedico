package it.appmedica;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrenotazione;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String motivazione;

	@Column(name="nome_ambulatorio")
	private String nomeAmbulatorio;

	@Column(name="nome_dottore")
	private String nomeDottore;

	private Time ora;

	@Column(name="tipologia_prenotazione")
	private String tipologiaPrenotazione;

	//bi-directional many-to-one association to Ambulatorio
	@ManyToOne
	private Ambulatorio ambulatorio;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	private Medico medico;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	private Utente utente;

	public Prenotazione() {
	}

	public int getIdPrenotazione() {
		return this.idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMotivazione() {
		return this.motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione = motivazione;
	}

	public String getNomeAmbulatorio() {
		return this.nomeAmbulatorio;
	}

	public void setNomeAmbulatorio(String nomeAmbulatorio) {
		this.nomeAmbulatorio = nomeAmbulatorio;
	}

	public String getNomeDottore() {
		return this.nomeDottore;
	}

	public void setNomeDottore(String nomeDottore) {
		this.nomeDottore = nomeDottore;
	}

	public Time getOra() {
		return this.ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}

	public String getTipologiaPrenotazione() {
		return this.tipologiaPrenotazione;
	}

	public void setTipologiaPrenotazione(String tipologiaPrenotazione) {
		this.tipologiaPrenotazione = tipologiaPrenotazione;
	}

	public Ambulatorio getAmbulatorio() {
		return this.ambulatorio;
	}

	public void setAmbulatorio(Ambulatorio ambulatorio) {
		this.ambulatorio = ambulatorio;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}