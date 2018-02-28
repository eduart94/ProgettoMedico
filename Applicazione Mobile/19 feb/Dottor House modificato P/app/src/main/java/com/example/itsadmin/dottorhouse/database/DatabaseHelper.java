package com.example.itsadmin.dottorhouse.database;

/**
 * Created by itsadmin on 14/02/2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "appmedica";

    public static final String TABLE_PRENOTAZIONE = "prenotazione";

    public static final String KEY_DATA = "data";
    public static final String KEY_ORA = "ora";
    public static final String KEY_MOTIVAZIONE = "motivazione";
    public static final String KEY_VISITA_EFFETTUATA = "visita_effettuata";


    public static final String TABLE_UTENTE = "utente";

    public static  final String KEY_DATA_DI_NASCITA = "data_di_nascita";
    public static  final String KEY_EMAIL_UTENTE = "email_utente";
    public static  final String KEY_PASSWORD = "password";


    public static final String TABLE_MEDICO = "medico";

    public static final String KEY_NOME = "nome";
    public static final String KEY_COGNOME = "cognome";
    public static final String KEY_EMAIL_MEDICO = "email_medico";
    public static final String KEY_NUMERO_TELEFONO = "numero_telefono";
    public static final String KEY_TIPOLOGIA = "tipologia";
    public static final String KEY_CITTA = "citta";
    public static final String KEY_INDIRIZZO = "indirizzo";


    public static final String TABLE_RECENSIONE = "recensione";

    public static final String KEY_VALUTAZIONE = "valutazione";
    public static final String KEY_COMMENTO = "commento";



    private static final String CREATE_PRENOTAZIONE_TABLE = "CREATE TABLE " + TABLE_PRENOTAZIONE + "("
            + KEY_DATA + " DATE NOT NULL, "
            + KEY_ORA + " TEXT NOT NULL, "
            + KEY_MOTIVAZIONE + " TEXT, "
            + KEY_EMAIL_UTENTE + " TEXT NOT NULL, "
            + KEY_EMAIL_MEDICO + " TEXT NOT NULL, "
            + KEY_VISITA_EFFETTUATA + " INTEGER NOT NULL, "
            + "PRIMARY KEY ("+KEY_DATA+", "+KEY_EMAIL_UTENTE+", "+KEY_EMAIL_MEDICO+"), "
            + "FOREIGN KEY (" + KEY_EMAIL_UTENTE + ") REFERENCES "+TABLE_UTENTE+"("+KEY_EMAIL_UTENTE+"), "
            + "FOREIGN KEY (" + KEY_EMAIL_MEDICO + ") REFERENCES "+TABLE_MEDICO+"("+KEY_EMAIL_MEDICO+"));";

    private static final String CREATE_UTENTE_TABLE = "CREATE TABLE " + TABLE_UTENTE + "("
            + KEY_NOME + " TEXT NOT NULL,"
            + KEY_COGNOME + " TEXT NOT NULL,"
            + KEY_DATA_DI_NASCITA + " DATE NOT NULL,"
            + KEY_EMAIL_UTENTE + " TEXT PRIMARY KEY NOT NULL,"
            + KEY_NUMERO_TELEFONO + " TEXT,"
            + KEY_CITTA + " TEXT,"
            + KEY_PASSWORD + " TEXT NOT NULL)";

    private static final String CREATE_MEDICO_TABLE = "CREATE TABLE " + TABLE_MEDICO + "("
    + KEY_NOME + " TEXT NOT NULL,"
    + KEY_COGNOME + " TEXT NOT NULL,"
    + KEY_EMAIL_MEDICO + " TEXT PRIMARY KEY NOT NULL,"
    + KEY_NUMERO_TELEFONO + " TEXT NOT NULL,"
    + KEY_TIPOLOGIA + " TEXT NOT NULL,"
    + KEY_CITTA  + " TEXT NOT NULL,"
    + KEY_INDIRIZZO + " TEXT NOT NULL)";

    private static final String CREATE_RECENSIONE_TABLE = "CREATE TABLE " + TABLE_RECENSIONE + "("
            + KEY_EMAIL_MEDICO + " TEXT PRIMARY KEY NOT NULL, "
            + KEY_VALUTAZIONE + " INTEGER, "
            + KEY_COMMENTO + " TEXT, "
            + "FOREIGN KEY (" + KEY_EMAIL_MEDICO + ") REFERENCES "+TABLE_MEDICO+" ("+KEY_EMAIL_MEDICO+"));";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRENOTAZIONE_TABLE);
        db.execSQL(CREATE_UTENTE_TABLE);
        db.execSQL(CREATE_MEDICO_TABLE);
        db.execSQL(CREATE_RECENSIONE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRENOTAZIONE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECENSIONE);

        onCreate(db);
    }
}
