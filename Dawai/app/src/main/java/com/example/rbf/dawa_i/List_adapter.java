package com.example.rbf.dawa_i;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramzi on 22/04/18.
 */

class List_adapter extends RecyclerView.Adapter<List_adapter.ViewHolder> {
    List<Medicaments> medicament;

    public List_adapter(List<Medicaments> medicament) {
        this.medicament = medicament;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicament_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nom.setText(medicament.get(position).getNom());
        holder.nbr_fois.setText("Nombres De Fois Par Jours : "+medicament.get(position).getNbr_fois());
        holder.nbr_compr.setText("Nombres De Comprimé Restants : "+medicament.get(position).getNbr_compr());


    }

    @Override
    public int getItemCount() {
        return medicament.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public TextView nbr_fois;
        public TextView nbr_compr;
        public ViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.nom_medicament);
            nbr_compr = itemView.findViewById(R.id.nombre_compr);
            nbr_fois = itemView.findViewById(R.id.nombre_fois);
        }
    }
}
