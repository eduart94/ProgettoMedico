package com.eduartbiba.eserciziolistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by itsadmin on 22/01/2018.
 */

public class Adapter extends ArrayAdapter<ListItem> {
    Context cxt;
    ArrayList<ListItem> valore;
    public Adapter(Context cxt, ArrayList<ListItem> valore){
        super(cxt,R.layout.item_row_layout, valore );

        this.cxt = cxt;
        this.valore = valore;

    }
     @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_row_layout, parent, false);
         TextView testo1 = rowView.findViewById(R.id.testo1);
         TextView testo2 = rowView.findViewById(R.id.testo2);
         TextView testo3 = rowView.findViewById(R.id.testo3);

         testo1.setText(valore.get(position).getContenuto());
         testo2.setText(valore.get(position).getNumeroCaratteri().toString());
         testo3.setText(valore.get(position).getNumeroClick().toString());

         return rowView;

}
}
