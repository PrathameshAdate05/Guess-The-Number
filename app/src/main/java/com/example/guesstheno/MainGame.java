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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            Intent intent = new Intent(MainGame.this, Win.class);
            String strcount = String.valueOf(count);
            intent.putExtra(Win.COUNT_EXTRA, strcount);
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