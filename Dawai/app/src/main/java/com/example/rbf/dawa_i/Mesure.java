package com.example.rbf.dawa_i;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ramzi on 29/04/2018.
 */
@Entity
public class Mesure {
    public Mesure(String nom, double valeur, String type, String date) {
        this.nom = nom;
        this.valeur = valeur;
        this.type = type;
        this.date = date;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "valeur")
    private double valeur;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "date")
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getValeur() {
        return valeur;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public void setType(String type) {
        this.type = type;
    }
}
