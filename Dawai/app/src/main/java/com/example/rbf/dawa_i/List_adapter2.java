package com.example.rbf.dawa_i;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ramzi on 30/04/2018.
 */

abstract class List_adapter2 extends BaseAdapter
{
    ArrayList<Mesure> mesures   ;
    Context context;

    public List_adapter2(ArrayList<Mesure> mesures, Context context) {
        this.mesures = mesures;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Mesure mesure = mesures.get(position);
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.mesure_items, null);
        }
        TextView nom = view.findViewById(R.id.nom_mesure);
        TextView valeur = view.findViewById(R.id.valeur);
        TextView type = view.findViewById(R.id.type);
        TextView date = view.findViewById(R.id.date_mesure);
        nom.setText(mesure.getNom());
        valeur.setText(String.valueOf(mesure.getValeur()));
        type.setText(mesure.getType());
        date.setText(mesure.getDate());
        return view;
    }


}

