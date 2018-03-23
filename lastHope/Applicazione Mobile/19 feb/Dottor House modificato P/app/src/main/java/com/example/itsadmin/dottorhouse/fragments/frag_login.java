package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.API.APIRegistrazione;
import com.example.itsadmin.dottorhouse.API.LoginAPI;
import com.example.itsadmin.dottorhouse.MainActivity;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.login;
import com.example.itsadmin.dottorhouse.models.ModelUtente;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class frag_login extends Fragment {

    String textlogin = "";
    String textPass = "";
    Activity parent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parent = (Activity) context;
    }

    public frag_login() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_login, container, false);


        final EditText editTextlogin = (EditText)view.findViewById(R.id.textEmailLogin);
        final EditText editTextPass = (EditText)view.findViewById(R.id.textLoginPass);
        TextView textregis = (TextView)view.findViewById(R.id.textRegis);
        Button btnAccedi = (Button)view.findViewById(R.id.buttonAccedi);
        ImageView accaount = (ImageView) view.findViewById(R.id.iconAccount);
        ImageView lock = (ImageView) view.findViewById(R.id.iconLock);

        textregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((login)getActivity()).cambiaFragment(new frag_registrazione());
            }
        });



        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textlogin = editTextlogin.getText().toString();
                textPass = editTextPass.getText().toString();

                Login(textlogin,textPass);
            }
        });


        return view;
    }

    private void Login(String email, String pass) {
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        LoginAPI loginAPI = retrofit.create(LoginAPI.class);
        Map<String, Object> map=new HashMap<>();
        map.put("emailUtente", email );
        map.put("passwordUtente", pass);
        Call <ModelUtente> call = loginAPI.faiLogin(map);
        call.enqueue(new Callback<ModelUtente>() {
            @Override
            public void onResponse(Call<ModelUtente> call, Response<ModelUtente> response) {

                System.out.println(response.body().toString());

                if(response.body().getEmail()!=null){

                    SharedPreferences prefs = parent.getSharedPreferences("Preferenze", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("EmailUtente", response.body().getEmail());
                    editor.putString("PasswordUtente", response.body().getPassword());
                    editor.putString("CognomeUtente", response.body().getCognome());
                    editor.putString("NomeUtente", response.body().getNome());
                    editor.putString("TelefonoUtente", response.body().getNumeroTelefono());
                    editor.putString("DataNascita", response.body().getDataNascita());
                    editor.commit();

                    Intent goMain = new Intent(getActivity(), MainActivity.class);
                    startActivity(goMain);
                }else{

                    Toast.makeText(getActivity(),"Credenziali errate",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelUtente> call, Throwable t) {

                Toast.makeText(getActivity(),"Credenziali errate",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
