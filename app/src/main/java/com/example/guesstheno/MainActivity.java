package com.example.guesstheno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    Animation start;
    TextView starttext;
    ImageView logo;
    private  static int SPLASH_SCREEN=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        logo=findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.anim).into(logo);
        start= AnimationUtils.loadAnimation(this,R.anim.splash);
        starttext=findViewById(R.id.animtext);
        starttext.setAnimation(start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,StartGame.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}