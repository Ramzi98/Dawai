package com.example.rbf.dawa_i;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramzi on 30/04/2018.
 */

public class List_Mesure extends AppCompatActivity {
    ListView lv;
    ArrayList<Mesure> m;
    List_adapter2 adapter2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        lv=findViewById(R.id.list_view_mesure);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();
        List mesure=db.mesure_requetes().getAllmesure();
        adapter2 = new List_adapter2(m,this) {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }
        };
        lv.setAdapter(adapter2);

    }
}
