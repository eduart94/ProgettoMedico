package com.example.itsadmin.dottorhouse.API;


import com.example.itsadmin.dottorhouse.models.ModelRegistrazione;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface APIRegistrazione {
    @GET("registrazione.php")
    Call<Integer> faiRegistrazione(@QueryMap Map<String, Object> valori);
}
