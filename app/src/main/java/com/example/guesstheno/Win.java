package com.example.guesstheno;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class Win extends AppCompatActivity {

    public static String COUNT_EXTRA="count";
    TextView score;
    TextView user;
    MediaPlayer music;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

//        Intent intent=getIntent();
//        String count=intent.getStringExtra(COUNT_EXTRA);
//        Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){

            String name=bundle.getString("name");
            String count=bundle.getString("count");

            user=findViewById(R.id.nameuser);
            user.setText(name);

            score=findViewById(R.id.Score);
            score.setText("Your Score :"+count);

            vibe();

        }

        music=MediaPlayer.create(Win.this,R.raw.winmusic);
        music.start();



        final KonfettiView konfettiView = findViewById(R.id.konfettiView);
        konfettiView.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                .addSizes(new Size(12, 5f))
                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                .streamFor(500, 5000L);
    }

    public void tapped(View view){
        Intent intent=new Intent(Win.this,StartGame.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void vibe(){
        Vibrator vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE){
            vibrator.vibrate(VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else{
            vibrator.vibrate(1000);
        }
    }
}