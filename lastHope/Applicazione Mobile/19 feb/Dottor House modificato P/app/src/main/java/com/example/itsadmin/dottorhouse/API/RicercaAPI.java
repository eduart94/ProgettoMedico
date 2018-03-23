package com.example.itsadmin.dottorhouse.API;


import com.example.itsadmin.dottorhouse.models.ModelMedico;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RicercaAPI {
    @GET("ricerca.php")
    Call<ArrayList<ModelMedico>> getRicerca(@QueryMap Map<String, Object> valori);
}
