package com.example.rbf.dawa_i;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramzi on 22/04/18.
 */

public class List_medic extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<Medicaments> medicament;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_medic);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

     AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
             .allowMainThreadQueries()
             .build();
        List medicament= db.medicaments_requetes().getAllmedicaments();
        adapter = new List_adapter(medicament);
        recyclerView.setAdapter(adapter);

    }
}
