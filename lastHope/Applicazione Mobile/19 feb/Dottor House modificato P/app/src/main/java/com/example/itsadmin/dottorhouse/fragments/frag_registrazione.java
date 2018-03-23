package com.example.itsadmin.dottorhouse.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.API.APIRegistrazione;
import com.example.itsadmin.dottorhouse.MainActivity;
import com.example.itsadmin.dottorhouse.ProfiloMedico;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.login;
import com.example.itsadmin.dottorhouse.models.ModelRegistrazione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class frag_registrazione extends Fragment {
    Activity parent;

    EditText editNome;
    EditText editCognome;
    EditText editDataDiNascita;
    EditText editTelefono;
    EditText editEmail;
    EditText editPassword;
    EditText editConfermaPassword;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parent = (Activity) context;

    }

    public frag_registrazione(){}

    @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    final View view = inflater.inflate(R.layout.frag_registrazione, container, false);

        editNome = (EditText) view.findViewById(R.id.editNome);
        editCognome = (EditText) view.findViewById(R.id.editCognome);
        editDataDiNascita = (EditText) view.findViewById(R.id.editData);
        editTelefono = (EditText) view.findViewById(R.id.editTelefono);
        editEmail = (EditText) view.findViewById(R.id.editEmail);
        editPassword = (EditText) view.findViewById(R.id.editPassword);
        editConfermaPassword = (EditText) view.findViewById(R.id.editConfermaPassword);

        ImageView iconNome = (ImageView)view.findViewById(R.id.iconNome);
        ImageView iconCognome = (ImageView)view.findViewById(R.id.iconCognome);
        ImageView iconDataDiNascita = (ImageView)view.findViewById(R.id.iconData);
        ImageView iconTel = (ImageView)view.findViewById(R.id.iconTel);
        ImageView iconEmail = (ImageView)view.findViewById(R.id.iconEmail);
        ImageView iconPass = (ImageView)view.findViewById(R.id.iconPass);
        ImageView iconConfermaPass = (ImageView)view.findViewById(R.id.iconConPass);


        final RadioButton radioAcconsento = (RadioButton)view.findViewById(R.id.radioAcconsento);
        radioAcconsento.setChecked(false);

        Button registrati = (Button)view.findViewById(R.id.buttonRegistrati);
        ImageButton buttonGoBack = (ImageButton)view.findViewById(R.id.goBack);


        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((login)getActivity()).cambiaFragment(new frag_login());
            }
        });

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view){

                if(editNome.getText().toString().isEmpty()||
                        editCognome.getText().toString().isEmpty()||
                        editDataDiNascita.getText().toString().isEmpty() ||
                        editTelefono.getText().toString().isEmpty() ||
                        editEmail.getText().toString().isEmpty() ||
                        editPassword.getText().toString().isEmpty()||
                        editConfermaPassword.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(),"Compilare tutti i campi", Toast.LENGTH_LONG).show();

                }
                else if (!(editPassword.getText().toString().equals(editConfermaPassword.getText().toString()))){
                    Toast.makeText(getActivity(), "La password non corrisponde", Toast.LENGTH_LONG).show();
                }
                else if (radioAcconsento.isChecked()== false) {
                    Toast.makeText(getActivity(), "Confermare consenso per la trattazione dei dati", Toast.LENGTH_LONG).show();
                }else{

                    InviaRegistrazione();
                }
            }
        });
        return view;
    }

    private void InviaRegistrazione() {
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        APIRegistrazione apiRegistrazione = retrofit.create(APIRegistrazione.class);
        Map<String, Object> map=new HashMap<>();
        map.put("emailUtente", editEmail.getText().toString());
        map.put("cognomeUtente", editCognome.getText().toString());
        map.put("nomeUtente", editNome.getText().toString());
        map.put("dataNascita", editDataDiNascita.getText().toString());
        map.put("numeroTelefono", editTelefono.getText().toString());
        map.put("passwordUtente", editPassword.getText().toString());
        Call<Integer> call = apiRegistrazione.faiRegistrazione(map);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.body() == 1){
                    Toast.makeText(getActivity(), "Registrazione effettuata", Toast.LENGTH_SHORT).show();
                    ((login)getActivity()).cambiaFragment(new frag_login());

                } else {
                    Toast.makeText(getActivity(), "Errore. Registrazione non effettuata", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                System.out.println("FAIL");

            }
        });



    }
}