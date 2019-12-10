package com.example.rbf.dawa_i;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


/**
 * Created by ramzi on 09/03/18.
 */

public class Page1 extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        //menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId())
                        {
                            case R.id.profil:
                                Toast.makeText(Page1.this,"Profil Button clicked",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.aj_medic:
                                Intent intent1= new Intent(Page1.this,Add_medicaments.class);
                                startActivity(intent1);
                                return true;
                            case R.id.aj_mes:
                                Intent intent3= new Intent(Page1.this,Add_mesure.class);
                                startActivity(intent3);
                                return true;
                            case R.id.mod_tra:
                                Toast.makeText(Page1.this,"Modifier Traitment Button clicked",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.list_medic:
                                Intent intent4= new Intent(Page1.this,List_medic.class);
                                startActivity(intent4);
                                return true;
                            case R.id.list_mesure:
                                Toast.makeText(Page1.this,"List Mesure Button clicked",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.medecins:
                                Toast.makeText(Page1.this,"Medcins Button clicked",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.rdv:
                                Toast.makeText(Page1.this,"RDV Button clicked",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.parametre:
                                Toast.makeText(Page1.this,"Paramatre Button clicked",Toast.LENGTH_SHORT).show();
                                Intent intent2= new Intent(Page1.this,Setting.class);
                                startActivity(intent2);
                                return true;
                            case R.id.apropos:
                                Toast.makeText(Page1.this,"A Propos Button clicked",Toast.LENGTH_SHORT).show();
                                return true;

                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );


//// --------------------------------------Floating button -----------------------------------------------------/////
        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.add_btn2);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);

        ImageView itemIcon1 = new ImageView(this);
        itemIcon1.setImageResource(R.drawable.ic_edit_black_24dp);
        SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();

        ImageView itemIcon2 = new ImageView(this);
        itemIcon2.setImageResource(R.drawable.add_btn2);
        SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();

        ImageView itemIcon3 = new ImageView(this);
        itemIcon3.setImageResource(R.drawable.ic_list_black_24dp);
        SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();


        final FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .attachTo(actionButton)
                .build();



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Page1.this,"button1 clicked",Toast.LENGTH_SHORT).show();
                actionMenu.close(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Page1.this,"button2 clicked",Toast.LENGTH_SHORT).show();
                actionMenu.close(true);
                Intent intent1= new Intent(Page1.this,Add_medicaments.class);
                startActivity(intent1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Page1.this,"button3 clicked",Toast.LENGTH_SHORT).show();
                actionMenu.close(true);
            }
        });
        //// --------------------------------------Floatin button -----------------------------------------------------/////







    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed()         {
        finish();

    }


}
