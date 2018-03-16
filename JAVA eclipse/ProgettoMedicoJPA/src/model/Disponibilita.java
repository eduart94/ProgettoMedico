package model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.Ambulatorio;
import model.Prenotazione;

@Entity
public class Disponibilita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDisponibilita;
	
	public int getIdDisponibilita() {
		return idDisponibilita;
	}

	public void setIdDisponibilita(int idDisponibilita) {
		this.idDisponibilita = idDisponibilita;
	}

	public Ambulatorio getAmbulatorio() {
		return ambulatorio;
	}

	public void setAmbulatorio(Ambulatorio ambulatorio) {
		this.ambulatorio = ambulatorio;
	}

	public List<Prenotazione> getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(List<Prenotazione> prenotazione) {
		this.prenotazione = prenotazione;
	}

	@ManyToOne
	@JoinColumn(nullable=false)
	@JsonIgnore
	private Ambulatorio ambulatorio;
	
	@OneToMany(mappedBy="disponibilita", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Prenotazione> prenotazione;
	

}
