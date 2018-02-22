package com.example.itsadmin.dottorhouse.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;

/**
 * Created by itsadmin on 14/02/2018.
 */

public class AdapterPrenotazioni extends ArrayAdapter<ModelPrenotazione> {

    Context c;
    ArrayList<ModelPrenotazione> lista;

    public AdapterPrenotazioni(Context c,ArrayList<ModelPrenotazione>lista){
        super(c, R.layout.item_prenotazione,lista);

        this.lista = lista;
        this.c = c;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){

        LayoutInflater lf = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View riga = lf.inflate(R.layout.item_prenotazione, parent, false);

        TextView data = (TextView)riga.findViewById(R.id.data);
        TextView ora = (TextView)riga.findViewById(R.id.ora);
        TextView citta = (TextView)riga.findViewById(R.id.citta);
        TextView indirizzo = (TextView)riga.findViewById(R.id.indirizzo);
        TextView medico = (TextView)riga.findViewById(R.id.medico);
        TextView tipologia = (TextView)riga.findViewById(R.id.tipologia);
        TextView motivazione = (TextView)riga.findViewById(R.id.motivazione);

        data.setText(lista.get(position).getData()+"");
        ora.setText(lista.get(position).getOra()+"");
        citta.setText(lista.get(position).getCitta()+"");
        indirizzo.setText(lista.get(position).getIndirizzo()+"");
        medico.setText(lista.get(position).getMedico()+"");
        tipologia.setText(lista.get(position).getTipologia()+"");
        motivazione.setText(lista.get(position).getMotivazione()+"");




        return riga;
    }
}

