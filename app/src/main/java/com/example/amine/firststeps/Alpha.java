package com.example.amine.firststeps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Alpha extends AppCompatActivity {

    ImageView imageView;
    int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z};
    int[] sounds = new int[]{R.raw.a, R.raw.b, R.raw.c, R.raw.d, R.raw.e, R.raw.f, R.raw.g, R.raw.h, R.raw.i, R.raw.j, R.raw.k, R.raw.l, R.raw.m, R.raw.n, R.raw.o, R.raw.p, R.raw.q, R.raw.r, R.raw.s, R.raw.t, R.raw.u, R.raw.v, R.raw.w, R.raw.x, R.raw.y, R.raw.z};
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        imageView= (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(images[i]);
    }

    public void back(View view) {

        if(i>0) {
            i--;
            imageView.setImageResource(images[i]);
        }

    }

    public void playSound(View view) {

        MediaPlayer player = MediaPlayer.create(this, sounds[i]);
        player.start();


    }

    public void forward(View view) {

        if (i<25) {
            i++;
            imageView.setImageResource(images[i]);
        }

        //else
        //{
        //  Toast.makeText(this, "Congratulations ! You Finished The Course ;)", Toast.LENGTH_LONG).show();
        //}

    }
}
