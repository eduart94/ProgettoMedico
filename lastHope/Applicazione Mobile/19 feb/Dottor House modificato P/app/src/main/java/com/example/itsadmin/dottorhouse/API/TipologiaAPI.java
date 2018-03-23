package com.example.itsadmin.dottorhouse.API;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TipologiaAPI {
    @GET("tipologie.php")
    Call<ArrayList<String>>getTipologie();
}
