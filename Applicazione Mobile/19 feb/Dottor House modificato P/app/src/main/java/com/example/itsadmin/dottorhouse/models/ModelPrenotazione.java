package com.example.itsadmin.dottorhouse.models;

import android.provider.ContactsContract;

import java.sql.Date;

/**
 * Created by itsadmin on 14/02/2018.
 */

public class ModelPrenotazione {

    Date data;
    String ora;
    String motivazione;
    String citta;
    String indirizzo;
    String medico;
    String tipologia;
    int visita_effettuata;


    public ModelPrenotazione(){


    }

    public ModelPrenotazione(Date data, String ora, String motivazione, String email_utente, String email_medico, String citta, String tipologia, String medico, String indirizzo, int visita_effettuata) {
        this.data = data;
        this.ora = ora;
        this.motivazione = motivazione;
        this.citta = citta;
        this.indirizzo = indirizzo;
        this.medico = medico;
        this.tipologia = tipologia;
        this.visita_effettuata = visita_effettuata;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }


    public int getVisita_effettuata() {
        return visita_effettuata;
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

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setVisita_effettuata(int visita_effettuata) {
        this.visita_effettuata = visita_effettuata;

    }
}
