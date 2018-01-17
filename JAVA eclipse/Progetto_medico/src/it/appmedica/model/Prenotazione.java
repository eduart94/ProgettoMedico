package it.appmedica.model;

import java.io.Serializable;
import javax.persistence.*;

import it.appmedica.model.Disponibilita;

import java.sql.Time;
import java.util.Date;
import java.util.List;


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
	
	@Column(nullable=false)
	private int recensione;
    
	public int getRecensione() {
		return recensione;
	}

	public void setRecensione(int recensione) {
		this.recensione = recensione;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
    
	@Column(nullable = false)
	private String motivazione;
	
	@JoinColumn(nullable=false)
	@ManyToOne(cascade=CascadeType.ALL)
	private Disponibilita disponibilita;
	
	@OneToMany(mappedBy= "prenotazione")
	private List<SlotCalendar> slotCalendar;

	public Disponibilita getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(Disponibilita disponibilita) {
		this.disponibilita = disponibilita;
	}

	public List<SlotCalendar> getSlotCalendar() {
		return slotCalendar;
	}

	public void setSlotCalendar(List<SlotCalendar> slotCalendar) {
		this.slotCalendar = slotCalendar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name="nome_ambulatorio", nullable = false)
	private String nomeAmbulatorio;

	@Column(name="nome_dottore", nullable = false)
	private String nomeDottore;
    
	@Column(nullable = false)
	private Time ora;

	@Column(name="tipologia_prenotazione", nullable = false)
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