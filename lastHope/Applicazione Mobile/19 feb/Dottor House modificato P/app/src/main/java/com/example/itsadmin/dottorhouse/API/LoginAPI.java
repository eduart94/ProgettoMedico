package com.example.itsadmin.dottorhouse.API;


import com.example.itsadmin.dottorhouse.models.ModelMedico;
import com.example.itsadmin.dottorhouse.models.ModelUtente;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface LoginAPI {
    @GET("login.php")
    Call<ModelUtente> faiLogin(@QueryMap Map<String , Object> valori );
}
