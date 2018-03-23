package com.example.itsadmin.dottorhouse.API;


import com.example.itsadmin.dottorhouse.models.ModelMedico;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface MedicoAPI {
    @GET("getMedico.php")
    Call<ModelMedico>getMedico(@QueryMap Map<String , Object> valori );
}
