package com.example.itsadmin.dottorhouse;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.API.MedicoAPI;
import com.example.itsadmin.dottorhouse.API.PrenotazioniAPI;
import com.example.itsadmin.dottorhouse.Utils.Utilita;
import com.example.itsadmin.dottorhouse.models.ModelMedico;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.PendingIntent.getActivity;

public class ProfiloMedico extends Activity{

    Calendar calendar;
    int day;
    int month;
    int year;
    int hour;
    int min;
    boolean dataIsSelected =false;
    EditText editTextData;
    EditText editTextOra;
    EditText txtmotivazione;
    TextView textEmailMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        String email = getIntent().getExtras().getString("email");

        calendar = Calendar.getInstance();


        day = calendar.get(Calendar.DAY_OF_WEEK);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        setContentView(R.layout.activity_prfilo_medico);
        ImageView im = (ImageView) findViewById(R.id.profilePicMedico);
        TextView textNomeMedico = (TextView) findViewById(R.id.nomeMedico);
        TextView textCognomeMedico = (TextView) findViewById(R.id.cognomeMedico);
        textEmailMedico = (TextView) findViewById(R.id.emailMedico);
        TextView textTelefonoMedico = (TextView) findViewById(R.id.telefonoMedico);
        TextView textTipologia = (TextView) findViewById(R.id.tipologia_medico);
        TextView textCittaMedico = (TextView) findViewById(R.id.citta_medico);
        TextView textIndirizzoMedico = (TextView) findViewById(R.id.indirizzo_medico);
        TextView txtData = (TextView) findViewById(R.id.txtData);
        TextView txtOra = (TextView) findViewById(R.id.txtOra);
        TextView txtMotivazione = (TextView)findViewById(R.id.txtMotivazione) ;


        ModelMedico medico = AggiornaMedico(email);

        textNomeMedico.setText(medico.getNome());
        textCognomeMedico.setText(medico.getCognome());
        textEmailMedico.setText(medico.getEmail());
        textTelefonoMedico.setText(medico.getNumero_telefono());
        textTipologia.setText(medico.getTipologia());
        textCittaMedico.setText(medico.getCitta());
        textIndirizzoMedico.setText(medico.getIndirizzo());

        txtmotivazione = (EditText)findViewById(R.id.editTextMotivazione);
        editTextOra = (EditText) findViewById(R.id.editTextOra);
        editTextOra.setEnabled(false);

        editTextData = (EditText) findViewById(R.id.editTextData);
        editTextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final DatePickerDialog datePickerDialog = new DatePickerDialog(ProfiloMedico.this, new DatePickerDialog.OnDateSetListener() {


                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                                          calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                            datePicker.setEnabled(false);


                        } else{
                            Toast.makeText(ProfiloMedico.this,day+"-"+(month + 1) +"-"+year+"",Toast.LENGTH_SHORT).show();
                            editTextData.setText(Utilita.formattaData(day+"",month+1+"",year+""));
                            dataIsSelected = true;
                            editTextOra.setEnabled(true);

                        }


                    }
                }, year, month, day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

                datePickerDialog.show();

            }
        });



        editTextOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataIsSelected){
              TimePickerDialog timePickerDialog = new TimePickerDialog(ProfiloMedico.this, new TimePickerDialog.OnTimeSetListener() {
                  @Override
                  public void onTimeSet(TimePicker timePicker, int hour, int min){

                      editTextOra.setText(Utilita.formattaOra(hour+"",min+""));
                  }

                }, hour, min, true);

                timePickerDialog.show();
            }
            else{
                    Toast.makeText(ProfiloMedico.this,"Selezionare una data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnPrenota = (Button) findViewById(R.id.btnPrenota);
        btnPrenota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(editTextData.getText().toString().isEmpty() ||
                        editTextOra.getText().toString().isEmpty()){
                    Toast.makeText(ProfiloMedico.this, "Scegli una data e un orario", Toast.LENGTH_SHORT).show();
                }else{

                   InviaPrenotazione();
                }
            }
        });



   }

   private ModelMedico AggiornaMedico(String email){
       ModelMedico medico = null;
       Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
       Retrofit retrofit= builder.build();
       MedicoAPI medicoAPI= retrofit.create(MedicoAPI.class);
       Map<String, Object> map=new HashMap<>();
       map.put("emailMedico", email);
       Call<ModelMedico>call=medicoAPI.getMedico(map);

       try {
           medico = call.execute().body();
       } catch (IOException e) {

           System.out.println("RIP");
       }

       return medico;
   }

    private void InviaPrenotazione() {
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl("http://192.168.0.80/scripts/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        PrenotazioniAPI prenotazioniAPI= retrofit.create(PrenotazioniAPI.class);

        Map<String, Object> map=new HashMap<>();
        map.put("emailMedico", textEmailMedico.getText().toString());
        map.put("emailUtente", getSharedPreferences("Preferenze", Context.MODE_PRIVATE).getString("EmailUtente", null));
        map.put("motivazione", txtmotivazione.getText().toString());
        map.put("dataPrenotazione", editTextData.getText().toString());
        map.put("ora",editTextOra.getText().toString());
        Call<Integer> call= prenotazioniAPI.faiPrenotazione(map);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.body() == 0){
                    Toast.makeText(ProfiloMedico.this, "Errore", Toast.LENGTH_LONG).show();
                }
                else if (response.body() == 1 ) {
                    Toast.makeText(ProfiloMedico.this, "Prenotazione effettuata", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                System.out.println("FAIL");
                System.out.println(t.getCause());
                System.out.println(t.getMessage());
            }
        });

    }
}
