package com.example.amine.firststeps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuFr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fr);
    }


    public void openAlpha(View view) {

        Intent intent=new Intent(this,AlphaFr.class);
        startActivity(intent);
    }

    public void openWords(View view) {

        Intent intent=new Intent(this,WordsFr.class);
        startActivity(intent);
    }

    public void openNumber(View view) {

        Intent intent = new Intent(this,NumbersFr.class);
        startActivity(intent);
    }
}
