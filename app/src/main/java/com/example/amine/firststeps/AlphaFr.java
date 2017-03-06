package com.example.amine.firststeps;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AlphaFr extends AppCompatActivity {

    ImageView imageView;
    int[] images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x, R.drawable.y, R.drawable.z};
    int[] sounds = new int[]{R.raw.aa, R.raw.bb, R.raw.cc, R.raw.dd, R.raw.ee, R.raw.ff, R.raw.gg, R.raw.hh, R.raw.ii, R.raw.jj, R.raw.kk, R.raw.ll, R.raw.mm, R.raw.nn, R.raw.oo, R.raw.pp, R.raw.qq, R.raw.rr, R.raw.ss, R.raw.tt, R.raw.uu, R.raw.vv, R.raw.ww, R.raw.xx, R.raw.yy, R.raw.zz};
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_fr);
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
    }
}
