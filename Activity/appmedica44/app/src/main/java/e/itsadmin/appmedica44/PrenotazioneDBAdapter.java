package e.itsadmin.appmedica44;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itsadmin on 30/01/2018.
 */

public class PrenotazioneDBAdapter {

    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public PrenotazioneDBAdapter(Context context){
        this.context= context;
    }
    public PrenotazioneDBAdapter open() throws SQLException{
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
        database.close();
    }

    //Operazioni da effettuare CRUD = CREATE, READ, UPDATE, DELETE

    public void aggiungiPrenotazione(Prenotazione prenotazione){
        open();
        ContentValues valore = new ContentValues();
        valore.put(DBHelper.KEY_PRENOTAZIONE_DATA, prenotazione.getData().toString());
        valore.put(DBHelper.KEY_PRENOTAZIONE_MOTIVAZIONE, prenotazione.getMotivazione());
        valore.put(DBHelper.KEY_PRENOTAZIONE_NOME_AMBULATORIO, prenotazione.getNome_ambulatorio());
        valore.put(DBHelper.KEY_PRENOTAZIONE_NOME_DOTTORE, prenotazione.getNome_dottore());
        valore.put(DBHelper.KEY_PRENOTAZIONE_ORA, prenotazione.getOra());
        valore.put(DBHelper.KEY_PRENOTAZIONE_RECENSIONE, prenotazione.getRecensione());
        valore.put(DBHelper.KEY_PRENOTAZIONE_TIPO, prenotazione.getTipo_prenotazione());

        database.insert(DBHelper.TABLE_PRENOTAZIONE, null, valore);
        close();
    }

    Prenotazione getPrenotazione (int id){
        open();

        Cursor cursor = database.query(DBHelper.TABLE_PRENOTAZIONE,
                new String[]{DBHelper.KEY_PRENOTAZIONE_ID,
                             DBHelper.KEY_PRENOTAZIONE_DATA,
                             DBHelper.KEY_PRENOTAZIONE_MOTIVAZIONE,
                             DBHelper.KEY_PRENOTAZIONE_NOME_AMBULATORIO,
                             DBHelper.KEY_PRENOTAZIONE_NOME_DOTTORE,
                             DBHelper.KEY_PRENOTAZIONE_ORA,
                             DBHelper.KEY_PRENOTAZIONE_RECENSIONE,
                             DBHelper.KEY_PRENOTAZIONE_TIPO},
                DBHelper.KEY_PRENOTAZIONE_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();

        Prenotazione prenotazione = new Prenotazione
                (Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_ID))),
                        Date cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_DATA)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_MOTIVAZIONE)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_NOME_AMBULATORIO)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_NOME_DOTTORE)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_ORA)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_RECENSIONE)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PRENOTAZIONE_TIPO)));

        return prenotazione;

    }

    public List<Prenotazione> ottieniTutteLePrenotazioni(){
        List<Prenotazione> listaPrenotazioni = new ArrayList<Prenotazione>();

        String query = "SELECT * FROM " + DBHelper.TABLE_PRENOTAZIONE;
    }
}
