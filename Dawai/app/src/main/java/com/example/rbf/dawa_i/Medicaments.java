package com.example.rbf.dawa_i;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ramzi on 23/04/18.
 */
@Entity
public class Medicaments {
    public Medicaments(String nom, String nbr_fois, String nbr_compr) {
        this.nom = nom;
        this.nbr_fois = nbr_fois;
        this.nbr_compr = nbr_compr;
    }

    @PrimaryKey(autoGenerate = true)
    private int id ;
    @ColumnInfo(name ="nom")
    private String nom;
    @ColumnInfo(name ="nombr_fois")
    private String nbr_fois;
    @ColumnInfo(name ="nbr_compr")
    private String nbr_compr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNbr_fois() {
        return nbr_fois;
    }

    public void setNbr_fois(String nbr_fois) {
        this.nbr_fois = nbr_fois;
    }

    public String getNbr_compr() {
        return nbr_compr;
    }

    public void setNbr_compr(String nbr_compr) {
        this.nbr_compr = nbr_compr;
    }
}
