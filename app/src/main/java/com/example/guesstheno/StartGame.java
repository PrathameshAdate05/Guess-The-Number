package com.example.guesstheno;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class StartGame extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name=findViewById(R.id.name);


    }
    public void startgame(View view){
        if(name.getText().toString().equals("")){
            name.setError("Enter name Please..");
        }
        else {
            Intent intent = new Intent(StartGame.this, MainGame.class);
            intent.putExtra("name",name.getText().toString());
            startActivity(intent);
        }
    }
}