package com.example.rbf.dawa_i;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.amirarcane.lockscreen.activity.EnterPinActivity;

/**
 * Created by ramzi on 10/03/18.
 */

public class Langue extends AppCompatActivity {
    //private static final String FONT_TEXT = "font/ALEAWB.TTF";
    //private static final String FONT_NUMBER = "font/BLKCHCRY.TTF";

    private static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_langue);

    }

    public void fct(View v)
    {
        Intent intent = new Intent(this, EnterPinActivity.class);
        startActivityForResult(intent, REQUEST_CODE);;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == EnterPinActivity.RESULT_BACK_PRESSED) {
                    Toast.makeText(this, "back pressed", Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                {
                    Intent intent1 =new Intent(this,Page1.class);
                    startActivity(intent1);
                }
                break;
        }

    }
}
