package com.example.rbf.dawa_i;

/**
 * Created by ramzi on 20/04/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.amirarcane.lockscreen.activity.EnterPinActivity;

public class Setting extends AppCompatActivity {
    private static final String FONT_TEXT = "font/ALEAWB.TTF";
    private static final String FONT_NUMBER = "font/BLKCHCRY.TTF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
    }
    public void changer(View v)
    {
        String bt = getResources().getResourceEntryName(v.getId());

        switch (bt)
        {
            case  "changer_pin" :{
                Intent intent = EnterPinActivity.getIntent(this,true,FONT_TEXT,FONT_NUMBER);
                startActivity(intent);
            }
        }
    }
}