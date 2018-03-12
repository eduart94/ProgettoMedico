package com.example.itsadmin.dottorhouse;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class ProfiloMedico extends Activity {


//    Calendar calendario =Calendar.getInstance();
//    EditText editTextData = (EditText)findViewById(R.id.editTextData);
//    EditText editTextOra = (EditText)findViewById(R.id.editTextOra);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     String email = getIntent().getExtras().getString("email");

        setContentView(R.layout.activity_prfilo_medico);
        ImageView im = (ImageView) findViewById(R.id.profilePicMedico);
        TextView textNomeMedico = (TextView) findViewById(R.id.nomeMedico);
        TextView textCognomeMedico = (TextView) findViewById(R.id.cognomeMedico);
        TextView textEmailMedico = (TextView) findViewById(R.id.emailMedico);
        TextView textTelefonoMedico = (TextView) findViewById(R.id.telefonoMedico);
        TextView textTipologia = (TextView) findViewById(R.id.tipologia_medico);
        TextView textCittaMedico = (TextView) findViewById(R.id.citta_medico);
        TextView textIndirizzoMedico = (TextView) findViewById(R.id.indirizzo_medico);

        TextView txtData = (TextView) findViewById(R.id.txtData);
        TextView txtOra = (TextView) findViewById(R.id.txtOra);

//        final DatePickerDialog.OnDateSetListener data = new DatePickerDialog.OnDateSetListener(){
//
//            @Override
//            public void onDateSet(DatePicker view, int anno, int mese, int giorno){
//                calendario.set(Calendar.YEAR, anno);
//                calendario.set(Calendar.MONTH, mese);
//                calendario.set(Calendar.DAY_OF_MONTH, giorno);
//                updateData();
//
//            }
//        };
//
//        editTextData.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                new DatePickerDialog(ProfiloMedico.this, data,
//                        calendario.get(Calendar.YEAR),
//                        calendario.get(Calendar.MONTH),
//                        calendario.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
//
//
////        editTextOra.setOnClickListener(new View.OnClickListener(){
////
////            @Override
////            public void onClick(View v){
////                Calendar orario = Calendar.getInstance();
////                int h = orario.get(Calendar.HOUR_OF_DAY);
////                int min = orario.get(Calendar.MINUTE);
////
////                TimePickerDialog timePicker;
////                timePicker = new TimePickerDialog(ProfiloMedico.this, new TimePickerDialog.OnTimeSetListener() {
////                    @Override
////                    public void onTimeSet(TimePicker timePicker, int selectedH, int selectedMin) {
////                        editTextOra.setText(selectedH + ":" + selectedMin);
////                    }
////                }, h, min, true);
////                timePicker.setTitle("Selezionare orario");
////                timePicker.show();
////
////            }
////        });
//   }
//
//
//    private void updateData() {
//        String myFormat = "dd/MM/yy";
//        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ITALY);
//        editTextData.setText(sdf.format(calendario.getTime()));
   }
    }
