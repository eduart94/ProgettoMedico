package e.itsadmin.appmedica44;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Profilo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_p);

       final ListView prenotazioni = (ListView)findViewById(R.id.listViewPrenotazioni);

       final ArrayList<ModelProfilo> lista = new ArrayList<ModelProfilo>();

        final AdapterProfilo ap = new AdapterProfilo(this, lista);
        prenotazioni.setAdapter((ListAdapter) ap);

        prenotazioni.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent dettagli = new Intent(Profilo.this,Dettagli.class);
               // dettagli.putExtra
                startActivity(dettagli);
            }
        });


    }
}
