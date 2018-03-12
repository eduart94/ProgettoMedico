package com.example.itsadmin.dottorhouse.models;

/**
 * Created by itsadmin on 15/02/2018.
 */

public class ModelRecensione {

    String emailMedico;
    int valutazione;
    String commento;

    public ModelRecensione(){
    }

    public ModelRecensione(String emailMedico, int valutazione, String commento){
        this.emailMedico=emailMedico;
        this.valutazione=valutazione;
        this.commento=commento;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }
}
