package com.example.guesstheno;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainGame extends AppCompatActivity {

    EditText input;
    Random random;
    TextView action;
    private int guess, ori, count = 0;
    Intent intent;
    String name,strcount;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        intent = new Intent(MainGame.this, Win.class);
        Intent intent2=new Intent();
        intent2=getIntent();
        name=intent2.getStringExtra("name");

        bundle=new Bundle();

        random = new Random();
        input = (EditText) findViewById(R.id.number);
        action = (TextView) findViewById(R.id.action);
        guess = random.nextInt(100 - 1 + 1) + 1;
    }

    public void submit(View view) {

        ori = Integer.parseInt(input.getText().toString());
//        Toast.makeText(this, "no" + guess, Toast.LENGTH_SHORT).show();

        if (ori == guess) {
            count++;
            action.setText("Guessed the number ");
            //Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();

             strcount = String.valueOf(count);
//            intent.putExtra(Win.COUNT_EXTRA, strcount);
            bundle.putString("name",name);
            bundle.putString("count",strcount);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (ori > guess) {
            count++;
            action.setText("Entered no is big than guess no");
            input.setText("");

        } else if (ori < guess) {
            count++;
            action.setText("Entered no is small than guess no");
            input.setText("");

        }

    }
}