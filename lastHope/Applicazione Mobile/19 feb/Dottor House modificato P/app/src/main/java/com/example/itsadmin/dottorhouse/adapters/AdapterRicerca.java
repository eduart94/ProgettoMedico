package com.example.itsadmin.dottorhouse.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.R;

import com.example.itsadmin.dottorhouse.models.ModelMedico;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;
import com.example.itsadmin.dottorhouse.models.ModelRicerca;

import java.util.ArrayList;

public class AdapterRicerca extends ArrayAdapter<ModelMedico> {

    Context c;
    ArrayList<ModelMedico> lista_medico;

    public AdapterRicerca(Context c, ArrayList<ModelMedico> lista_medico) {
        super(c, R.layout.item_ricerca, lista_medico);

        this.lista_medico = lista_medico;
        this.c = c;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){

        LayoutInflater lf = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View riga = lf.inflate(R.layout.item_ricerca, parent, false);

        TextView tipologia = (TextView)riga.findViewById(R.id.item_tipologia);
        TextView nomeMedico = (TextView)riga.findViewById(R.id.item_nome_medico);
        TextView cognomeMedico = (TextView)riga.findViewById(R.id.item_cognome_medico);
        TextView citta = (TextView)riga.findViewById(R.id.item_citta);

        tipologia.setText(lista_medico.get(position).getTipologia());
        nomeMedico.setText(lista_medico.get(position).getNome());
        cognomeMedico.setText(lista_medico.get(position).getCognome());
        citta.setText(lista_medico.get(position).getCitta());

        lista_medico.get(position).toString();


        return riga;
    }


}