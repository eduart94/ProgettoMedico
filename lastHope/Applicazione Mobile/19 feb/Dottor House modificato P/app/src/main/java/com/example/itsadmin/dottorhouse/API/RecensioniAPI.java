package com.example.itsadmin.dottorhouse.API;


import com.example.itsadmin.dottorhouse.models.ModelRecensione;

import java.util.ArrayList;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RecensioniAPI {
    @POST("recensisci.php")
    Call<Integer> faiRecensione(@QueryMap Map<String, Object> valori);

}
