package com.example.amine.firststeps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openAlpha(View view) {

        Intent intent=new Intent(this,Alpha.class);
        startActivity(intent);
    }

    public void openWords(View view) {

        Intent intent=new Intent(this,Words.class);
        startActivity(intent);
    }


    public void openNumbers(View view) {

        Intent intent=new Intent(this,Numbers.class);
        startActivity(intent);
    }
}
