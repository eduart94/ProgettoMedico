package com.example.itsadmin.dottorhouse.models;


public class ModelRicerca {
    String tipologia;
    String nomeMedico;
    String citta;
    String indirizzo;

    public ModelRicerca() {
    }

    public ModelRicerca(String tipologia, String nomeMedico, String citta, String indirizzo) {
        this.tipologia = tipologia;
        this.nomeMedico = nomeMedico;
        this.citta = citta;
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
