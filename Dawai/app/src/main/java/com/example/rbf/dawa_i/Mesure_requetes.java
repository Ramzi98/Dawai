package com.example.rbf.dawa_i;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ramzi on 29/04/2018.
 */

@Dao
public interface Mesure_requetes {
    @Query("SELECT * FROM mesure")
    List<Mesure> getAllmesure();
    @Insert
    void insertAll(Mesure mesure);
}
