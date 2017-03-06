package com.example.amine.firststeps;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NumbersFr extends AppCompatActivity {

    ImageView imageView;
    int[] images = new int[]{R.drawable.n0, R.drawable.n1, R.drawable.n2, R.drawable.n3, R.drawable.n4, R.drawable.n5, R.drawable.n6, R.drawable.n7, R.drawable.n8, R.drawable.n9};
    int[] sounds = new int[]{R.raw.n0, R.raw.n1, R.raw.n2, R.raw.n3, R.raw.n4, R.raw.n5, R.raw.n6, R.raw.n7, R.raw.n8, R.raw.n9};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_fr);
        imageView= (ImageView) findViewById(R.id.imageView4);
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
        if (i<9) {
            i++;
            imageView.setImageResource(images[i]);
        }
    }
}
