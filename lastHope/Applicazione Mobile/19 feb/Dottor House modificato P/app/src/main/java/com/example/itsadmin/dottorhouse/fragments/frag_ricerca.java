package com.example.itsadmin.dottorhouse.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaSync;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.API.TipologiaAPI;
import com.example.itsadmin.dottorhouse.ProfiloMedico;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterRicerca;
import com.example.itsadmin.dottorhouse.cursor.TipologiaCursorAdapter;
import com.example.itsadmin.dottorhouse.models.ModelMedico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.itsadmin.dottorhouse.API.RicercaAPI;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class frag_ricerca extends Fragment {
    TipologiaCursorAdapter tca;

    ArrayList<ModelMedico> lmr;
    Spinner spinner;
    AdapterRicerca adapter;
    EditText citta;
    ArrayAdapter <String> adapterSpinner;
    ArrayList <String> tipologie;


    public frag_ricerca(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.ricerca, container, false);


        TextView textTipologia = (TextView) view.findViewById(R.id.textTipologia);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        citta = (EditText) view.findViewById(R.id.citta);
        Button cerca = (Button) view.findViewById(R.id.cerca);
        ListView risultatiRicerca = (ListView) view.findViewById(R.id.lista_medico);


        lmr = new ArrayList<>();
        adapter = new AdapterRicerca(getActivity(), lmr);
        risultatiRicerca.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        tipologie = new ArrayList<>();


        adapterSpinner = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,tipologie);
        spinner.setAdapter(adapterSpinner);
        Tipologie();

        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lmr.clear();
                adapter.notifyDataSetChanged();


                //Cursor c = (Cursor) spinner.getSelectedItem();
                String tipologia = (String) spinner.getSelectedItem();
                String stringaCitta = citta.getText().toString();

                AggiornaRicerca(tipologia, stringaCitta);

            }
        });

        risultatiRicerca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent openProfiloMedico = new Intent(getActivity(), ProfiloMedico.class);
                openProfiloMedico.putExtra("email",lmr.get(i).getEmail());
                startActivity(openProfiloMedico);



            }
        });



        return view;
    }

    public void Tipologie(){
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        TipologiaAPI tipologiaAPI= retrofit.create(TipologiaAPI.class);
        Call<ArrayList<String>> call= tipologiaAPI.getTipologie();
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                tipologie.clear();
                adapterSpinner.notifyDataSetChanged();
                tipologie.add("");
                tipologie.addAll(response.body());
                adapterSpinner.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {

            }
        });



    }

    public void AggiornaRicerca(String tipologia, String citta){
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        RicercaAPI ricercaAPI= retrofit.create(RicercaAPI.class);
        Map<String, Object> map=new HashMap<>();
        map.put("tipologia", tipologia);
        map.put("citta", citta);
        Call<ArrayList<ModelMedico>> call= ricercaAPI.getRicerca(map);
        call.enqueue(new Callback<ArrayList<ModelMedico>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelMedico>> call, Response<ArrayList<ModelMedico>> response) {

                lmr.clear();
                adapter.notifyDataSetChanged();
                lmr.addAll(response.body());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<ModelMedico>> call, Throwable t) {

            }
        });
    }


}