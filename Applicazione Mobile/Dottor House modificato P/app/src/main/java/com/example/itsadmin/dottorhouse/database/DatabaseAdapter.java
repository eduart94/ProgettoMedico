package com.example.itsadmin.dottorhouse.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;

import java.sql.Date;
import java.util.ArrayList;


public class DatabaseAdapter {


    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public DatabaseAdapter(Context context) {
        this.context = context;
    }

    public DatabaseAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }

    void addPrenotazione(ModelPrenotazione modelPrenotazione){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_DATA, String.valueOf(modelPrenotazione.getData()));
        values.put(DatabaseHelper.KEY_ORA, modelPrenotazione.getOra());
        values.put(DatabaseHelper.KEY_MOTIVAZIONE, modelPrenotazione.getMotivazione());
        values.put(DatabaseHelper.KEY_VISITA_EFFETTUATA, modelPrenotazione.getVisita_effettuata());



        database.insert(DatabaseHelper.TABLE_PRENOTAZIONE, null, values);

        close();
    }


    public ArrayList<ModelPrenotazione> getAllPrenotazioni(){
        ArrayList<ModelPrenotazione> tuttePrenotazioni = new ArrayList<ModelPrenotazione>();

        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_PRENOTAZIONE;

        open();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                ModelPrenotazione prenotazione = new ModelPrenotazione();
                prenotazione.setData(Date.valueOf(cursor.getString(1)));
                prenotazione.setOra(cursor.getString(2));
                prenotazione.setMotivazione(cursor.getString(3));
              //  prenotazione.setEmail_utente(cursor.getString(4));
                //prenotazione.setEmail_medico(cursor.getString(5));
                prenotazione.setVisita_effettuata(cursor.getInt(6));

                tuttePrenotazioni.add(prenotazione);
            } while (cursor.moveToNext());
        }
        close();
        return tuttePrenotazioni;
    }


    public ArrayList<ModelPrenotazione> getVisiteFatte(){
        ArrayList<ModelPrenotazione> visiteFatte = new ArrayList<ModelPrenotazione>();

        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_PRENOTAZIONE + " WHERE visita_effettuata=1"; //visite già fatte

        open();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                ModelPrenotazione prenotazione = new ModelPrenotazione();
                prenotazione.getData();
                prenotazione.getOra();
                prenotazione.getMotivazione();
              //  prenotazione.getEmail_utente();
                //prenotazione.getEmail_medico();
            } while (cursor.moveToNext());
        } close();
        return visiteFatte;
    }


}
