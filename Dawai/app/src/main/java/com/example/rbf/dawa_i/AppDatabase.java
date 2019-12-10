package com.example.rbf.dawa_i;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by ramzi on 23/04/18.
 */
@Database(entities = {Medicaments.class,Mesure.class} , version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Medicaments_requetes medicaments_requetes();
    public abstract Mesure_requetes mesure_requetes();
}
