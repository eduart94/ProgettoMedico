package it.appmedica.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;


@Entity
public class SlotCalendar {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_slot_calendar")
	private int idSlotCalendar;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public int getIdSlotCalendar() {
		return idSlotCalendar;
	}

	public void setIdSlotCalendar(int idSlotCalendar) {
		this.idSlotCalendar = idSlotCalendar;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public DateTime getOra() {
		return ora;
	}

	public void setOra(DateTime ora) {
		this.ora = ora;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Column(nullable=false)
	@Temporal(TemporalType.TIME)
	private DateTime ora;
	
	@JoinColumn(nullable = false)
    @ManyToOne(cascade= CascadeType.ALL)
    private Prenotazione prenotazione;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Medico medico;
	

}
