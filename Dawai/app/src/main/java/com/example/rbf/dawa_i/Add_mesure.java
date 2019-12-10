package com.example.rbf.dawa_i;

import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ramzi on 21/04/18.
 */

public class Add_mesure extends AppCompatActivity {
    Dialog d1,d2,d3,d4,d5;
    int d=0;
    EditText e1;
    Spinner s1,s2,s3,s4,s5;
    double val;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d1= new Dialog(this);
        d2= new Dialog(this);
        d3= new Dialog(this);
        d4= new Dialog(this);
        d5= new Dialog(this);

        setContentView(R.layout.add_mesure);
        d1.setContentView(R.layout.dialog1);
        d2.setContentView(R.layout.dialog2);
        d3.setContentView(R.layout.dialog3);
        d4.setContentView(R.layout.dialog4);
        d5.setContentView(R.layout.dialog5);
        db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();





    }



    public void mesure(View v)
    {
        String bt = getResources().getResourceEntryName(v.getId());
        switch (bt)
        {
            case  "glycemie" :
            {
                d1.show();
                d=1;
                e1=d1.findViewById(R.id.m1);
                break;
            }
            case "tension":
            {
                d2.show();
                d=2;
                e1=d2.findViewById(R.id.m1);

                break;
            }
            case "frequence":
            {
                d3.show();
                d=3;
                e1=d3.findViewById(R.id.m1);




                break;
            }
            case "poids":
            {
                d4.show();
                d=4;
                e1=d4.findViewById(R.id.m1);




                break;
            }
            case "temp":
            {
                d5.show();
                d=5;
                e1=d5.findViewById(R.id.m1);




                break;
            }

        }
    }

    public void annuler_mesure(View v)
    {
        switch (d)
        {
            case 1 :
                d1.dismiss();
            case 2 :
                d2.dismiss();
            case 3 :
                d3.dismiss();
            case 4 :
                d4.dismiss();
            case 5 :
                d5.dismiss();
        }

    }


    public void ajouter_mesure(View v)
    {
        val=Double.parseDouble(e1.getText().toString());
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm ");
        String datetime = dateformat.format(c.getTime());
        switch (d)
        {

            case 1 :
                s1=d1.findViewById(R.id.sp1);
                String s=s1.getSelectedItem().toString();
                Mesure mesure1=new Mesure("Glycemie",val,s,datetime);
                db.mesure_requetes().insertAll(mesure1);
                Intent intent3= new Intent(Add_mesure.this,List_Mesure.class);
                startActivity(intent3);
                break;

            case 2 :
                s2=d2.findViewById(R.id.sp2);
                Mesure mesure2=new Mesure("Tension Artérielle",val,s1.getSelectedItem().toString(),datetime);
                db.mesure_requetes().insertAll(mesure2);
            case 3 :
                s3=d3.findViewById(R.id.sp3);
                Mesure mesure3=new Mesure("Frequence Cardiaque",val,s1.getSelectedItem().toString(),datetime);
                db.mesure_requetes().insertAll(mesure3);
            case 4 :
                s4=d4.findViewById(R.id.sp4);
                Mesure mesure4=new Mesure("Poids",val,s1.getSelectedItem().toString(),datetime);
                db.mesure_requetes().insertAll(mesure4);
            case 5 :
                s5=d5.findViewById(R.id.sp5);
                Mesure mesure5=new Mesure("Tempurature",val,s1.getSelectedItem().toString(),datetime);
                db.mesure_requetes().insertAll(mesure5);

        }

    }
}