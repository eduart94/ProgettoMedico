package com.example.itsadmin.dottorhouse.models;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class ModelPrenotazione {

    int idPrenotazione;
    int recensione;
    String motivazione;
    String ora;
    String emailMedico;
    String emailUtente;
    @SerializedName("data")
    String dataStringa;
    String nomePaese;
    String indirizzo;
    String tipologia;
    String nomeMedico;
    String cognomeMedico;

    public ModelPrenotazione() {
    }

    public ModelPrenotazione(int idPrenotazione, int recensione, String motivazione, String ora, String emailMedico, String emailUtente, String dataStringa, String nomePaese, String indirizzo, String tipologia, String nomeMedico, String cognomeMedico) {
        this.idPrenotazione = idPrenotazione;
        this.recensione = recensione;
        this.motivazione = motivazione;
        this.ora = ora;
        this.emailMedico = emailMedico;
        this.emailUtente = emailUtente;
        this.dataStringa = dataStringa;
        this.nomePaese = nomePaese;
        this.indirizzo = indirizzo;
        this.tipologia = tipologia;
        this.nomeMedico=nomeMedico;
        this.cognomeMedico=cognomeMedico;
    }

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public int getRecensione() {
        return recensione;
    }

    public void setRecensione(int recensione) {
        this.recensione = recensione;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    public String getDataStringa() {
        return dataStringa;
    }

    public void setDataStringa(String dataStringa) {
        this.dataStringa = dataStringa;
    }

    public String getNomePaese() {
        return nomePaese;
    }

    public void setNomePaese(String nomePaese) {
        this.nomePaese = nomePaese;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCognomeMedico() {
        return cognomeMedico;
    }

    public void setCognomeMedico(String cognomeMedico) {
        this.cognomeMedico = cognomeMedico;
    }
}
