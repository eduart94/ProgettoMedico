package com.example.itsadmin.dottorhouse.models;



public class ModelAmbulatorio {

    int idAmbulatorio;
    String indirizzo;
    ModelCitta citta;

    public ModelAmbulatorio() {
    }

    public ModelAmbulatorio(int idAmbulatorio, String indirizzo, ModelCitta citta) {
        this.idAmbulatorio = idAmbulatorio;
        this.indirizzo = indirizzo;
        this.citta=citta;
    }

    public int getIdAmbulatorio() {
        return idAmbulatorio;
    }

    public void setIdAmbulatorio(int idAmbulatorio) {
        this.idAmbulatorio = idAmbulatorio;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public ModelCitta getCitta() {
        return citta;
    }

    public void setCitta(ModelCitta citta) {
        this.citta = citta;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;


    }
}
