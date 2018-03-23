package com.example.itsadmin.dottorhouse.adapters;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.API.PrenotazioniAPI;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.itsadmin.dottorhouse.Interfacce.Interfaccia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdapterPrenotazioni extends ArrayAdapter<ModelPrenotazione>{

    Context c;
    ArrayList<ModelPrenotazione> lista;
    Dialog dialog;
    Interfaccia interfaccia;
    int itemDaCancellare;

    public AdapterPrenotazioni(Context c, ArrayList<ModelPrenotazione> lista, Interfaccia interfaccia){
        super(c, R.layout.item_prenotazione,lista);

        this.lista = lista;
        this.c = c;
        this.interfaccia=interfaccia;
    }


    public View getView (final int position, View contentView, ViewGroup parent){
        LayoutInflater lf = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View riga = lf.inflate(R.layout.item_prenotazione, parent, false);

        TextView data = (TextView)riga.findViewById(R.id.data);
        TextView ora = (TextView)riga.findViewById(R.id.ora);
        TextView citta = (TextView)riga.findViewById(R.id.citta);
        TextView indirizzo = (TextView)riga.findViewById(R.id.indirizzo);
        TextView medico = (TextView)riga.findViewById(R.id.medico);
        TextView tipologia = (TextView)riga.findViewById(R.id.tipologia);
        TextView motivazione = (TextView)riga.findViewById(R.id.motivazione);
        TextView emailMedico = (TextView)riga.findViewById(R.id.emailMedico);
        Button btnCancella = (Button)riga.findViewById(R.id.btnCancella);

        data.setText("Data: " + lista.get(position).getDataStringa()+"");
        ora.setText("Ora: " + lista.get(position).getOra()+"");
        citta.setText("Città: " + lista.get(position).getNomePaese()+"");
        indirizzo.setText("Indirizzo: " + lista.get(position).getIndirizzo()+"");
//        medico.setText("Medico: " + lista.get(position).get
//        tipologia.setText("Tipologia: " + lista.get(position).get
        motivazione.setText("Motivazione: " + lista.get(position).getMotivazione()+"");
        emailMedico.setText(c.getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("tipologia", null));



        btnCancella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemDaCancellare=lista.get(position).getIdPrenotazione();
                popupCancella();
            }
        });

        return riga;
    }

    private void popupCancella() {
        dialog = new Dialog(c);
        dialog.setContentView(R.layout.popup_cancella);
        dialog.setTitle("Cancellazione");

        Button btnOk = (Button)dialog.findViewById(R.id.btnOK);
        Button btnAnnulla = (Button)dialog.findViewById(R.id.btnAnnulla);

        btnAnnulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.hide();

                interfaccia.CancellaPrenotazione(itemDaCancellare);

            }
        });

        dialog.show();

    }




}
