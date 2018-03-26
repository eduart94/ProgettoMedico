package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.adapters.AdapterPrenotazioni;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.itsadmin.dottorhouse.API.PrenotazioniAPI;


import com.example.itsadmin.dottorhouse.Interfacce.Interfaccia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.view.View.VISIBLE;


public class frag_home extends Fragment implements Interfaccia{
    ArrayList<ModelPrenotazione> listaPrenotazioni;
    AdapterPrenotazioni ap;
    Activity parent;
    TextView txtNonP;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        parent = (Activity)context;
    }

    public frag_home (){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        txtNonP = (TextView)view.findViewById(R.id.txtNonP);
        TextView textPrenotazioni = (TextView)view.findViewById(R.id.textPrenotazioni);
        ListView listVisiteDaFare = (ListView)view.findViewById(R.id.listaVisite);

        listaPrenotazioni = new ArrayList<>();

        ap = new AdapterPrenotazioni(getActivity(), listaPrenotazioni, this);
        listVisiteDaFare.setAdapter(ap);
        ap.notifyDataSetChanged();


        AggiornaPrenotazioni();

        if(listaPrenotazioni.size()==0){
            txtNonP.setVisibility(View.VISIBLE);
        }

        return view;
    }

    private void AggiornaPrenotazioni(){

        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        PrenotazioniAPI prenotazioniAPI= retrofit.create(PrenotazioniAPI.class);
        Map<String, Object> map=new HashMap<>();
        map.put("emailUtente", parent.getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("EmailUtente", null));
        map.put("effettuate", 0);
        Call<ArrayList<ModelPrenotazione>> call= prenotazioniAPI.getPrenotazioni(map);
        call.enqueue(new Callback<ArrayList<ModelPrenotazione>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelPrenotazione>> call, Response<ArrayList<ModelPrenotazione>> response) {
                listaPrenotazioni.clear();
                ap.notifyDataSetChanged();
                if(response.body()!=null)
                    listaPrenotazioni.addAll(response.body());

                System.out.println(response.raw());
                System.out.println(response.errorBody());
                System.out.println(response.message());

                ap.notifyDataSetChanged();
                System.out.println("FUNZIONA");
            }

            @Override
            public void onFailure(Call<ArrayList<ModelPrenotazione>> call, Throwable t) {
                System.out.println("NON FUNZIONA");
                System.out.println(t.getMessage());
                System.out.println(t.getCause());


            }
        });

    }


    @Override
    public void CancellaPrenotazione (final int id) {

        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        PrenotazioniAPI prenotazioniAPI= retrofit.create(PrenotazioniAPI.class);

        Map<String, Object> map=new HashMap<>();
        map.put("idPrenotazione", id);

        Call <Integer> call = prenotazioniAPI.cancPrenotazione(map);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

                if(response.body() == 1){

                    Toast.makeText(getActivity(),"Prenotazione cancellata",Toast.LENGTH_SHORT).show();

                    for (int i = 0;i<listaPrenotazioni.size();i++){

                        if(listaPrenotazioni.get(i).getIdPrenotazione()==id){
                            listaPrenotazioni.remove(i);
                        }
                    }

                    ap.notifyDataSetChanged();

                    if(listaPrenotazioni.size()==0)
                        txtNonP.setVisibility(View.VISIBLE);

                }else{

                    Toast.makeText(getActivity(),"Prenotazione non cancellata",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });


    }
}
