package com.example.itsadmin.dottorhouse.adapters;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsadmin.dottorhouse.API.RecensioniAPI;
import com.example.itsadmin.dottorhouse.Interfacce.InterfaceRecensione;
import com.example.itsadmin.dottorhouse.R;
import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;
import com.example.itsadmin.dottorhouse.models.ModelRecensione;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AdapterStorico extends ArrayAdapter<ModelPrenotazione> {

    Context c;
    ArrayList<ModelPrenotazione> lista;
    Dialog dialog;
    InterfaceRecensione interfaceRecensione;

    public AdapterStorico(Context c, ArrayList<ModelPrenotazione>lista, InterfaceRecensione interfaceRecensione){
        super(c, R.layout.item_history,lista);

        this.lista = lista;
        this.c = c;
        this.interfaceRecensione = interfaceRecensione;
    }

    @Override
    public View getView(final int position, View contentView, ViewGroup parent){

        LayoutInflater lf = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View riga = lf.inflate(R.layout.item_history, parent, false);

        TextView data = (TextView)riga.findViewById(R.id.data);
        TextView citta = (TextView)riga.findViewById(R.id.citta);
        TextView indirizzo = (TextView)riga.findViewById(R.id.indirizzo);
        TextView medico = (TextView)riga.findViewById(R.id.medico);
        TextView tipologia = (TextView)riga.findViewById(R.id.tipologia);
        TextView motivazione = (TextView)riga.findViewById(R.id.motivazione);
        TextView emailMedico = (TextView)riga.findViewById(R.id.emailMedico);
        Button btnRecensisci = (Button) riga.findViewById(R.id.btnRecensici);

        data.setText("Data: " + lista.get(position).getDataStringa()+"");
        citta.setText("Città: " + lista.get(position).getNomePaese()+"");
        indirizzo.setText("Indirizzo: " +lista.get(position).getIndirizzo()+"");
        medico.setText("Medico: " +lista.get(position).getNomeMedico()+ " " + lista.get(position).getCognomeMedico()+"");
        tipologia.setText("Tipologia: " +lista.get(position).getTipologia()+"");
        motivazione.setText("Motivazione: " +lista.get(position).getMotivazione()+"");
        emailMedico.setText("Email: " +lista.get(position).getEmailMedico()+"");

        btnRecensisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupValutazione(lista.get(position).getIdPrenotazione());
            }
        });




        return riga;
    }

    public void popupValutazione(final int id){
        dialog= new Dialog(c);
        dialog.setContentView(R.layout.popup_valutazione);
        dialog.setTitle("Valutazione");

        final RatingBar ratingBar = (RatingBar)dialog.findViewById(R.id.ratingBar);
        Button btnOk = (Button)dialog.findViewById(R.id.btnOK);
        Button btnAnnulla = (Button)dialog.findViewById(R.id.btnAnnulla);

        btnAnnulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.hide();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ratingBar.getProgress()>=1){

                    interfaceRecensione.recensisci(ratingBar.getProgress(),id);
                    dialog.hide();
                }else{

                    Toast.makeText(c,"Selezionare almeno una stella",Toast.LENGTH_LONG).show();
                }

            }
        });

        dialog.show();
    }


}


