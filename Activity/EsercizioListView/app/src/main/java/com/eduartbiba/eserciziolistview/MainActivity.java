package com.eduartbiba.eserciziolistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

   static ArrayList<ListItem> lista = new ArrayList<ListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listSiti = (ListView)findViewById(R.id.lista);
        final EditText inserisciSite = (EditText)findViewById(R.id.editText3);
        Button pulsante = (Button)findViewById(R.id.button);


        final Adapter adp = new Adapter(this,lista );

        listSiti.setAdapter(adp);

        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inserisciSite.getText().toString().length() >0){
                    ListItem li = new ListItem(inserisciSite.getText().toString(), inserisciSite.getText().toString().length(), 0);
                    lista.add(li);

                   adp.notifyDataSetChanged();
                  listSiti.setAdapter(adp);
                }
            }
        });

        listSiti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                lista.get(position).incrementa();

                adp.notifyDataSetChanged();
                listSiti.setAdapter(adp);

            }

        });
        listSiti.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                lista.remove(position);

                adp.notifyDataSetChanged();
                listSiti.setAdapter(adp);

                return true;


            }
        });
    }
}
