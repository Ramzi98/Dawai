package com.example.rbf.dawa_i;

import android.app.Activity;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import nl.dionsegijn.steppertouch.StepperTouch;


/**
 * Created by ramzi on 20/04/18.
 */

public class Add_medicaments extends AppCompatActivity{
    EditText nom_medicament;
    EditText nbr_fois;
    RadioGroup duree;
    RadioButton continu;
    RadioButton nbr_jours;
    RadioGroup jours;
    RadioButton tous_les_jours;
    RadioButton jours_specifique;
    RadioButton intervalle;
    RadioButton cycle;
    RadioGroup instruction;
    RadioButton avant_repas;
    RadioButton pendant_repas;
    RadioButton apres_repas;
    RadioButton peu_importe;
    EditText nbr_compr;
    AppDatabase db;
    StepperTouch s;
    ImageView im;
    int REQUEST_CAMERA=1,SELECT_FILE=0;
    String str;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
       db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"production")
                .allowMainThreadQueries()
                .build();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicament);
        nom_medicament=findViewById(R.id.nom_medicament);
        duree=findViewById(R.id.duree);
        continu=findViewById(R.id.continu);
        nbr_jours=findViewById(R.id.nbr_jours);
        jours=findViewById(R.id.jours);
        tous_les_jours=findViewById(R.id.tous_les_jours);
        jours_specifique=findViewById(R.id.jours_specifique);
        intervalle=findViewById(R.id.intervalle);
        cycle=findViewById(R.id.cycle);
        instruction=findViewById(R.id.instruction);
        avant_repas=findViewById(R.id.avant_repas);
        pendant_repas=findViewById(R.id.pendant_repas);
        apres_repas=findViewById(R.id.apres_repas);
        peu_importe=findViewById(R.id.peu_importe);
        nbr_compr=findViewById(R.id.nbr_compr);
        s=findViewById(R.id.stepperTouch);
        s.stepper.setMin(0);
        s.stepper.setMax(10);
        s.enableSideTap(true);
        im = findViewById(R.id.img);
        str= String.valueOf(s.getStepper().getValue());




    }

    public void posologie (View v)
    {


    }
    public void select_date(View v)
    {

    }

    public void ajouter_image(View v)
    {
        final  CharSequence[] items={"Camera","Gallery","Cancel"};
        AlertDialog.Builder builder= new AlertDialog.Builder(Add_medicaments.this);
        builder.setTitle("Add Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(items[i].equals("Camera"))
                {
                    Intent intent1=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent1,REQUEST_CAMERA);
                }
                else if (items[i].equals("Gallery"))
                {
                    Intent intent2 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent2.setType("image/*");
                    startActivityForResult(intent2,SELECT_FILE);

                }
                else if (items[i].equals("Cancel"))
                {
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_OK)
        {
            if(requestCode == REQUEST_CAMERA)
            {
                Bundle bundle = data.getExtras();
                final  Bitmap bitmap =(Bitmap) bundle.get("data");
                im.setImageBitmap(bitmap);
            }
            else if (requestCode==SELECT_FILE)
            {
                Uri selectedimageUri=data.getData();
                im.setImageURI(selectedimageUri);
            }
        }

    }



    public void add_medicament(View v)
    {
        if (!(nom_medicament.getText().toString().isEmpty()) && !(nbr_compr.getText().toString().isEmpty()))
        {
            Medicaments medicaments=new Medicaments(nom_medicament.getText().toString(),str,nbr_compr.getText().toString());
            db.medicaments_requetes().insertAll(medicaments);
            Intent intent3= new Intent(Add_medicaments.this,List_medic.class);
            startActivity(intent3);
        }
        else
        {
            Toast.makeText(Add_medicaments.this,"Remplir Toutes Les Cases SVP",Toast.LENGTH_SHORT).show();
        }
    }

    public void annuler(View v)
    {
        Add_medicaments.this.finish();
    }

}
