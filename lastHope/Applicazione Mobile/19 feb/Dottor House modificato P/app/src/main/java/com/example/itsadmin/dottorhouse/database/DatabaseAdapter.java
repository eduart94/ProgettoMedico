//package com.example.itsadmin.dottorhouse.database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.example.itsadmin.dottorhouse.models.ModelMedico;
//import com.example.itsadmin.dottorhouse.models.ModelPrenotazione;
//
//import java.sql.Date;
//import java.util.ArrayList;
//
//
//public class DatabaseAdapter {
//
//
//    private Context context;
//    private SQLiteDatabase database;
//    private DatabaseHelper dbHelper;
//
//    public DatabaseAdapter(Context context) {
//        this.context = context;
//    }
//
//    public DatabaseAdapter open() throws SQLException {
//        dbHelper = new DatabaseHelper(context);
//        database = dbHelper.getWritableDatabase();
//
//        return this;
//    }
//
//    public void close() {
//        dbHelper.close();
//        database.close();
//    }
//
//    public void addmedico (ModelMedico m){
//
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHelper.KEY_NOME,m.getNome());
//        values.put(DatabaseHelper.KEY_COGNOME,m.getCognome());
//        values.put(DatabaseHelper.KEY_EMAIL_MEDICO,m.getEmail());
//        values.put(DatabaseHelper.KEY_NUMERO_TELEFONO,m.getNumeroTelefono());
//        values.put(DatabaseHelper.KEY_TIPOLOGIA,m.getTipologia());
//        values.put(DatabaseHelper.KEY_CITTA,m.());
//        values.put(DatabaseHelper.KEY_INDIRIZZO,m.getIndirizzo());
//        open();
//        database.insert(DatabaseHelper.TABLE_MEDICO, null, values);
//        close();
//    }
//
//    void addPrenotazione(ModelPrenotazione modelPrenotazione){
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHelper.KEY_DATA, String.valueOf(modelPrenotazione.getData()));
//        values.put(DatabaseHelper.KEY_ORA, modelPrenotazione.getOra());
//        values.put(DatabaseHelper.KEY_MOTIVAZIONE, modelPrenotazione.getMotivazione());
//        values.put(DatabaseHelper.KEY_VISITA_EFFETTUATA, modelPrenotazione.isIniziato());
//
//
//
//        database.insert(DatabaseHelper.TABLE_PRENOTAZIONE, null, values);
//
//        close();
//    }
//
//
//    public ArrayList<ModelPrenotazione> getAllPrenotazioni(){
//        ArrayList<ModelPrenotazione> tuttePrenotazioni = new ArrayList<ModelPrenotazione>();
//
//        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_PRENOTAZIONE;
//
//        open();
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()){
//            do{
//                ModelPrenotazione prenotazione = new ModelPrenotazione();
//                prenotazione.setData((cursor.getString(1)));
//                prenotazione.setOra(cursor.getString(2));
//                prenotazione.setMotivazione(cursor.getString(3));
//              //  prenotazione.setEmail_utente(cursor.getString(4));
//                //prenotazione.setEmail_medico(cursor.getString(5));
//                prenotazione.setVisita_effettuata(cursor.getInt(6));
//
//                tuttePrenotazioni.add(prenotazione);
//            } while (cursor.moveToNext());
//        }
//        close();
//        return tuttePrenotazioni;
//    }
//
//
//    public ArrayList<ModelPrenotazione> getVisiteFatte(){
//        ArrayList<ModelPrenotazione> visiteFatte = new ArrayList<ModelPrenotazione>();
//
//        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_PRENOTAZIONE + " WHERE visita_effettuata=1"; //visite già fatte
//
//        open();
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()){
//            do{
//                ModelPrenotazione prenotazione = new ModelPrenotazione();
//                prenotazione.getData();
//                prenotazione.getOra();
//                prenotazione.getMotivazione();
//
//              //  prenotazione.getEmail_utente();
//                //prenotazione.getEmail_medico();
//            } while (cursor.moveToNext());
//        } close();
//        return visiteFatte;
//    }
//
//    public ArrayList<ModelMedico> getMedici(String tipologia){
//        ArrayList<ModelMedico> Medici = new ArrayList<ModelMedico>();
//        String selectQuery = "SELECT * FROM " + DatabaseHelper.TABLE_MEDICO + " WHERE " +DatabaseHelper.KEY_TIPOLOGIA+" = '" + tipologia+"'";
//
//        open();
//        Cursor cursor = database.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()){
//            do{
//
//                Medici.add(new ModelMedico(cursor.getString(0),cursor.getString(1),cursor.getString(2),
//                        cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
//                //  prenotazione.getEmail_utente();
//                //prenotazione.getEmail_medico();
//            } while (cursor.moveToNext());
//        }
//
//
//
//        close();
//        return Medici;
//    }
//
//    public Cursor getAllTipologie(){
//
//
//        String selectQuery = "SELECT DISTINCT "+DatabaseHelper.KEY_TIPOLOGIA+" AS _id FROM " + DatabaseHelper.TABLE_MEDICO;
//
//        open();
//        Cursor cursor = database.rawQuery(selectQuery, null);
//
//
//        return cursor;
//    }
//
//
//}
