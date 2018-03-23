package com.example.itsadmin.dottorhouse.API;


import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface PrenotazioniAPI {

    @GET("prenota.php")
    Call<ArrayList<ModelPrenotazione>>getPrenotazioni(@QueryMap Map <String, Object> valori); //string=id obj=valore


    @GET("faiPrenotazione.php")
    Call<Integer>faiPrenotazione(@QueryMap Map <String, Object> val);

    @GET("prenotazioneCanc.php")
        Call<Integer>cancPrenotazione(@QueryMap Map <String , Object> valori );
    }


