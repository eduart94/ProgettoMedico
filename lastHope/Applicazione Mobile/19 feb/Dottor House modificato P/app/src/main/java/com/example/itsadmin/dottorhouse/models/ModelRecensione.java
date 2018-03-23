package com.example.itsadmin.dottorhouse.models;


public class ModelRecensione {

    String emailMedico;
    int valutazione;

    public ModelRecensione(){
    }

    public ModelRecensione(String emailMedico, int valutazione){
        this.emailMedico=emailMedico;
        this.valutazione=valutazione;
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

}
