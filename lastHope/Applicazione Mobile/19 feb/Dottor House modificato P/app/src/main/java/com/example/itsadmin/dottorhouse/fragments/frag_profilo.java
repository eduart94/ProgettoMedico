package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.API.RecensioniAPI;
import com.example.itsadmin.dottorhouse.Interfacce.InterfaceRecensione;
import com.example.itsadmin.dottorhouse.ProfiloMedico;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterStorico;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.itsadmin.dottorhouse.API.PrenotazioniAPI;
import com.example.itsadmin.dottorhouse.models.ModelRecensione;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class frag_profilo extends Fragment implements InterfaceRecensione{

    AdapterStorico adpt;
    ArrayList<ModelPrenotazione>lista;
    Activity parent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parent = (Activity) context;
    }

    public frag_profilo(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        lista = new ArrayList<ModelPrenotazione>();

        final View view = inflater.inflate(R.layout.fragment_profilo, container, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView cognome = (TextView) view.findViewById(R.id.cognome);
        TextView mail = (TextView) view.findViewById(R.id.mail);
        TextView storico = (TextView) view.findViewById(R.id.storicoPrenotazioni);
        ImageView profilePic = (ImageView) view.findViewById(R.id.profilePic);
        ListView listaVisiteFatte = (ListView) view.findViewById(R.id.listaPren);
        mail.setText(parent.getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("EmailUtente", null));
        nome.setText(parent.getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("NomeUtente", null));
        cognome.setText(parent.getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("CognomeUtente", null));


        adpt = new AdapterStorico(getActivity(), lista, this);

        System.out.println("Adapter settato");

        listaVisiteFatte.setAdapter(adpt);
        adpt.notifyDataSetChanged();

        AggiornaPrenotazioni();

        return view;
    }

    private void AggiornaPrenotazioni(){
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        PrenotazioniAPI prenotazioniAPI= retrofit.create(PrenotazioniAPI.class);
        Map<String, Object> map=new HashMap<>();
        map.put("emailUtente", parent.getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("EmailUtente", null));
        map.put("effettuate", 1);
        Call<ArrayList<ModelPrenotazione>> call= prenotazioniAPI.getPrenotazioni(map);
        call.enqueue(new Callback<ArrayList<ModelPrenotazione>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelPrenotazione>> call, Response<ArrayList<ModelPrenotazione>> response) {
                lista.clear();
                adpt.notifyDataSetChanged();
                lista.addAll(response.body());
                adpt.notifyDataSetChanged();
                System.out.println("Siiii puòòòòò fareeeeee!!!!");
            }

            @Override
            public void onFailure(Call<ArrayList<ModelPrenotazione>> call, Throwable t) {
                System.out.println("Ritenta, sarai più fortunato");


            }
        });

    }


    @Override
    public void recensisci(int recens, int idPren) {

        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        RecensioniAPI recensioniAPI= retrofit.create(RecensioniAPI.class);
        Map<String, Object> map=new HashMap<>();
        map.put("idPrenotazione", idPren);
        map.put("recensione", recens);

        Call <Integer> call = recensioniAPI.faiRecensione(map);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

                if (response.body() == 0){
                    Toast.makeText(getActivity(), "Errore", Toast.LENGTH_SHORT).show();
                }
                else if (response.body() == 1 ) {
                    Toast.makeText(getActivity(), "Recensione effettuata", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

                System.out.println("FAIL");
            }
        });
    }


}

