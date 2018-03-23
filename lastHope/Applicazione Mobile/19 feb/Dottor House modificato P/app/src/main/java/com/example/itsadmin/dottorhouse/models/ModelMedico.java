package com.example.itsadmin.dottorhouse.models;


import com.google.gson.annotations.SerializedName;

public class ModelMedico {

    @SerializedName("nomeMedico")
    String nome;
    @SerializedName("cognomeMedico")
    String cognome;
    @SerializedName("emailMedico")
    String email;
    @SerializedName("numeroTelefono")
    String numero_telefono;
    String tipologia;
    String indirizzo;
    String citta;

    public ModelMedico() {
    }

    public ModelMedico(String nome, String cognome, String email, String numero_telefono, String tipologia, String INDIRIZZO, String NOME) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numero_telefono = numero_telefono;
        this.tipologia = tipologia;
        this.indirizzo = indirizzo;
        this.citta = citta;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}

