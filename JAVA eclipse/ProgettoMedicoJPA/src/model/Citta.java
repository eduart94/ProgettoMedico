package model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Citta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCitta;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String paese;
	
	@OneToMany(mappedBy="citta", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(nullable=false )
	@JsonIgnore
	private List<Ambulatorio> ambulatori;
	
	public int getIdCitta() {
		return idCitta;
	}

	public void setIdCitta(int idCitta) {
		this.idCitta = idCitta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public List<Ambulatorio> getAmbulatori() {
		return ambulatori;
	}

	public void setAmbulatori(List<Ambulatorio> ambulatori) {
		this.ambulatori = ambulatori;
	}

	public Citta() {
		
	}

}
