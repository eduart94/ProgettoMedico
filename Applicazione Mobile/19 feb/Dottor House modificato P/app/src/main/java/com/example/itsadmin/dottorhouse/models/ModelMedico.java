package com.example.itsadmin.dottorhouse.models;

/**
 * Created by itsadmin on 15/02/2018.
 */

public class ModelMedico {

    String nome;
    String cognome;
    String emailMedico;
    String numero_telefono;
    String tipologia;
    String citta;
    String indirizzo;

    public ModelMedico(){
    }

    public ModelMedico( String nome, String cognome, String emailMedico, String numero_telefono, String tipologia, String citta, String indirizzo, int recensioni){
        this.nome=nome;
        this.cognome=cognome;
        this.emailMedico=emailMedico;
        this.numero_telefono=numero_telefono;
        this.tipologia=tipologia;
        this.citta=citta;
        this.indirizzo=indirizzo;
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

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
