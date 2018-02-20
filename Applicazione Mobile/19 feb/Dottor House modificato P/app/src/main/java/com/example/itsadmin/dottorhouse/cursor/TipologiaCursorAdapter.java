package com.example.itsadmin.dottorhouse.cursor;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.itsadmin.dottorhouse.R;

public class TipologiaCursorAdapter extends CursorAdapter {
    public TipologiaCursorAdapter(Context context, Cursor cursor){
        super(context, cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tipologia, parent, false);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tipologia = (TextView) view.findViewById(R.id.tipologia);
        tipologia.setText(cursor.getString(cursor.getColumnIndex("tipologia")));
    }


}
