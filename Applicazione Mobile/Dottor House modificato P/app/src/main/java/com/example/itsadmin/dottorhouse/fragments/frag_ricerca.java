package com.example.itsadmin.dottorhouse.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.ProfiloMedico;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterRicerca;
import com.example.itsadmin.dottorhouse.cursor.TipologiaCursorAdapter;
import com.example.itsadmin.dottorhouse.database.DatabaseAdapter;
import com.example.itsadmin.dottorhouse.database.DatabaseHelper;
import com.example.itsadmin.dottorhouse.models.ModelMedico;
import com.example.itsadmin.dottorhouse.models.ModelRicerca;

import java.util.ArrayList;
import java.util.List;

public class frag_ricerca extends Fragment {
    TipologiaCursorAdapter tca;

    ArrayList<ModelRicerca> lmr;
    DatabaseAdapter databaseAdapter;
    Spinner spinner;
    AdapterRicerca adapter;


    public frag_ricerca(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.ricerca, container, false);


        TextView textTipologia = (TextView)view.findViewById(R.id.textTipologia);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        EditText citta = (EditText)view.findViewById(R.id.citta);
        Button cerca = (Button) view.findViewById(R.id.cerca);
        ListView risultatiRicerca = (ListView) view.findViewById(R.id.lista_medico);
        databaseAdapter = new DatabaseAdapter(getActivity());

        //spinner
        tca = new TipologiaCursorAdapter(getActivity(), databaseAdapter.getAllTipologie());

        //tca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(tca);
        databaseAdapter.close();
        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener())


        //listView
        lmr = new ArrayList<>();
        final AdapterRicerca adapter = new AdapterRicerca(getActivity(),lmr);
        risultatiRicerca.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //button
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList <ModelMedico> aus = new ArrayList<>();
                Cursor c = (Cursor) spinner.getSelectedItem();
                String tipologia = c.getString(c.getColumnIndex("_id"));
                aus = databaseAdapter.getMedici(tipologia);

                for(ModelMedico m : aus){

                    lmr.add(new ModelRicerca(m.getTipologia(),m.getNome(),m.getCitta(),m.getIndirizzo()));
                    Log.d("frag_ricerca", "" + m.getTipologia() + m.getNome() +m.getCitta()+m.getIndirizzo());
                }


                adapter.notifyDataSetChanged();
            }
        });

        risultatiRicerca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent openProfiloMedico = new Intent(getActivity(), ProfiloMedico.class);

                EditText nomeMedico = (EditText)view.findViewById(R.id.nomeMedico);
                EditText cognomeMedico = (EditText)view.findViewById(R.id.cognomeMedico) ;
                EditText emailMedico = (EditText)view.findViewById(R.id.emailMedico) ;
                EditText telMedico = (EditText)view.findViewById(R.id.telefonoMedico);
                EditText tipologia = (EditText)view.findViewById(R.id.tipologia_medico);
                EditText citta = (EditText)view.findViewById(R.id.citta);
                EditText indirizzo = (EditText)view.findViewById(R.id.indirizzo);

                // intent activity medico con un putExtra = nomeMedico
                openProfiloMedico.putExtra("nomeMedico",nomeMedico.getText());
                openProfiloMedico.putExtra("cognomeMedico",cognomeMedico.getText());
               // openProfiloMedico.putExtra("emailMedico",emailMedico.getText());
                //openProfiloMedico.putExtra("telMedico",telMedico.getText());

                openProfiloMedico.putExtra("tipologia",tipologia.getText());
                openProfiloMedico.putExtra("citta",citta.getText());
                openProfiloMedico.putExtra("indirizzo",indirizzo.getText());
                startActivity(openProfiloMedico);



            }
        });



        return view;
    }


}