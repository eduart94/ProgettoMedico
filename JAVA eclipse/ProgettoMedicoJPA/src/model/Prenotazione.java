package model;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.Disponibilita;

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
	private int id;
	
	@Column(nullable=false)
	private int recensione;
    
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable = false)
	private Time ora;

    @Column(nullable = false)
	private String motivazione;
	
	@JoinColumn(nullable=false)
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private Disponibilita disponibilita;
	
	@OneToMany(mappedBy= "prenotazione")
	@JoinColumn(nullable=false)
	@JsonIgnore
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

	
    
	
	

	//bi-directional many-to-one association to Ambulatorio
	@ManyToOne
	@JoinColumn(nullable=false)
	@JsonIgnore
	private Ambulatorio ambulatorio;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(nullable=false)
	@JsonIgnore
	private Medico medico;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(nullable=false)
	@JsonIgnore
	private Utente utente;
	
	public int getRecensione() {
		return recensione;
	}

	public void setRecensione(int recensione) {
		this.recensione = recensione;
	}

	public Prenotazione() {
	}
	public Prenotazione(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setIdPrenotazione(int id) {
		this.id = id;
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

	

	public Time getOra() {
		return this.ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
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