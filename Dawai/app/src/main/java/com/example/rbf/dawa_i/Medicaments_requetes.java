package com.example.rbf.dawa_i;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ramzi on 23/04/18.
 */
@Dao
public interface Medicaments_requetes {
    @Query("SELECT * FROM medicaments")
    List<Medicaments> getAllmedicaments();
    @Insert
    void insertAll(Medicaments... medicaments);
}
