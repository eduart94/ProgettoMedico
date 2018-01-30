package e.itsadmin.appmedica44;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "appMedica";

    public static final String TABLE_AMBULATORIO = "ambulatorio";
    public static final String KEY_AMBULATORIO_ID_ = "idAmbulatorio";
    public static final String KEY_AMBULATORIO_lATITUDINE = "latitudine";
    public static final String KEY_AMBULATORIO_lONGITUDINE = "longitudine";

    public static final String CREATE_AMBULATORIO_TABLE = "CREATE TABLE" + TABLE_AMBULATORIO + "("
            + KEY_AMBULATORIO_ID_ + "INTEGER PRIMARY KEY,"
            + KEY_AMBULATORIO_lATITUDINE + "INTEGER,"
            + KEY_AMBULATORIO_lONGITUDINE + "INTEGER" + ")";



    public static final String TABLE_DISPONIBILTA = "disponibilita";
    public static final String KEY_DISPONIBILITA_ID = "idDisponibilita";

    public static final String CREATE_DISPONIBILITA_TABLE = "CREATE TABLE" + TABLE_DISPONIBILTA + "("
            +KEY_DISPONIBILITA_ID + "INTEGER PRIMARY KEY" + ")";

    public static final String TABLE_CITTA = "citta";
    public static final String KEY_CITTA_ID = "idCitta";
    public static final String KEY_CITTA_NOME = "nomeCitta";
    public static final String KEY_CITTA_PAESE = "paeseCitta";

    public static final String CREATE_CITTA_TABLE ="CREATE TABLE" +  TABLE_CITTA + "("
            +KEY_CITTA_ID +"INTEGER PRIMARY KEY,"
            + KEY_CITTA_NOME +"TEXT,"
            + KEY_CITTA_PAESE +"TEXT"+ ")";

    public static final String TABLE_MEDICO = "medico";
    public static final String KEY_MEDICO_ID = "idMedico";
    public static final String KEY_MEDICO_CODICE_FISCALE = "codice_fiscale_medico";
    public static final String KEY_MEDICO_COGNOME = "cognomeMedico";
    public static final String KEY_MEDICO_DATA_NASCITA = "dataNascitaMedico";
    public static final String KEY_MEDICO_EMAIL = "emailMedico";
    public static final String KEY_MEDICO_NOME = "nomeMedico";
    public static final String KEY_MEDICO_NUMERO_TELEFONO= "numeroTelefonoMedico";
    public static final String KEY_MEDICO_PASSWORD = "passwordMedico";
    public static final String KEY_MEDICO_TIPOLOGIA = "tipologiaMedico";

    public static final String CREATE_MEDICO_TABLE ="CREATE TABLE" + TABLE_MEDICO + "("
            + KEY_MEDICO_ID + "INTEGER PRIMARY KEY,"
            + KEY_MEDICO_CODICE_FISCALE + "TEXT,"
            + KEY_MEDICO_COGNOME + "TEXT,"
            + KEY_MEDICO_DATA_NASCITA + "DATE,"
            + KEY_MEDICO_EMAIL + "TEXT,"
            + KEY_MEDICO_NOME + "TEXT,"
            + KEY_MEDICO_NUMERO_TELEFONO + "TEXT,"
            + KEY_MEDICO_PASSWORD + "TEXT,"
            + KEY_MEDICO_TIPOLOGIA + "TEXT" + ")";

    public static final String TABLE_PRENOTAZIONE = "prenotazione";
    public static final String KEY_PRENOTAZIONE_ID= "idPrenotazione";
    public static final String KEY_PRENOTAZIONE_DATA = "dataPrenotazione";
    public static final String KEY_PRENOTAZIONE_MOTIVAZIONE = "motivazione";
    public static final String KEY_PRENOTAZIONE_NOME_AMBULATORIO= "nomeAmbulatorioPrenotazione";
    public static final String KEY_PRENOTAZIONE_NOME_DOTTORE = "nomeDottorePrenotazione";
    public static final String KEY_PRENOTAZIONE_ORA = "oraPrenotazione";
    public static final String KEY_PRENOTAZIONE_RECENSIONE= "recensione";
    public static final String KEY_PRENOTAZIONE_TIPO = "tipoPrenotazione";

    public static final String CREATE_PRENOTAZIONE_TABLE = "CREATE TABLE" + TABLE_PRENOTAZIONE + "("
            + KEY_PRENOTAZIONE_ID + "INTEGER PRIMARY KEY,"
            + KEY_PRENOTAZIONE_DATA + "DATE,"
            + KEY_PRENOTAZIONE_MOTIVAZIONE + "TEXT,"
            + KEY_PRENOTAZIONE_NOME_AMBULATORIO + "TEXT,"
            + KEY_PRENOTAZIONE_NOME_DOTTORE + "TEXT,"
            + KEY_PRENOTAZIONE_ORA + "TEXT,"
            + KEY_PRENOTAZIONE_RECENSIONE + "INTEGER,"
            + KEY_PRENOTAZIONE_TIPO + "TEXT" + ")";

    public static final String TABLE_UTENTE = "utente";
    public static final String KEY_UTENTE_ID= "idUtente";
    public static final String KEY_UTENTE_DATA_NASCITA = "dataNascitaUtente";
    public static final String KEY_UTENTE_CODICE_FISCALE = "codiceFiscaleUtente";
    public static final String KEY_UTENTE_COGNOME= "cognomeUtente";
    public static final String KEY_UTENTE_NOME = "nomeUtente";
    public static final String KEY_UTENTE_EMAIL = "emailUtente";
    public static final String KEY_UTENTE_NUMERO_TELEFONO= "numeroTelefonoUtente";
    public static final String KEY_UTENTE_USERNAME = "usernameUtente";
    public static final String KEY_UTENTE_PASSWORD = "passwordUtente";

    public static final String CREATE_UTENTE_TABLE = "CREATE TABLE" + TABLE_UTENTE + "("
            + KEY_UTENTE_ID + "INTEGER PRIMARY KEY,"
            + KEY_UTENTE_DATA_NASCITA + "DATE,"
            + KEY_UTENTE_CODICE_FISCALE + "TEXT,"
            + KEY_UTENTE_COGNOME + "TEXT,"
            + KEY_UTENTE_NOME + "TEXT,"
            + KEY_UTENTE_EMAIL + "TEXT,"
            + KEY_UTENTE_NUMERO_TELEFONO + "TEXT,"
            + KEY_UTENTE_USERNAME + "TEXT,"
            + KEY_UTENTE_PASSWORD + "TEXT" + ")";

    public static final String TABLE_SLOTCALENDAR = "slotCalendar";
    public static final String KEY_SLOTCALENDAR_ID= "idSlotCalendar";
    public static final String KEY_SLOTCALENDAR_DATA = "dataSlotCalendar";
    public static final String KEY_SLOTCALENDAR_ORA = "oraSlotCalendar";

    public static final String CREATE_SLOTCALENDAR_TABLE = "CREATE TABLE" + TABLE_SLOTCALENDAR + "("
            + KEY_SLOTCALENDAR_ID + "INTEGER PRIMARY KEY,"
            + KEY_SLOTCALENDAR_DATA + "DATE,"
            + KEY_SLOTCALENDAR_ORA + "TEXT" + ")";

    public DBHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_AMBULATORIO_TABLE);
        db.execSQL(CREATE_CITTA_TABLE);
        db.execSQL(CREATE_DISPONIBILITA_TABLE);
        db.execSQL(CREATE_MEDICO_TABLE);
        db.execSQL(CREATE_PRENOTAZIONE_TABLE);
        db.execSQL(CREATE_SLOTCALENDAR_TABLE);
        db.execSQL(CREATE_UTENTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(String.format("DROP TABLE IF EXISTS%s", TABLE_PRENOTAZIONE));
        onCreate(db);
    }
}
