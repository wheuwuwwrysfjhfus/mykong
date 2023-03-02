package com.example.mykong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mykong.MyDatabase;
import com.example.mykong.R;

public class MainActivity extends AppCompatActivity {
    // declare MyDatabase class as myDatabase
    MyDatabase myDatabase;
    Button buttonSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call MyDatabase class to create database
        myDatabase = new MyDatabase(this);

        buttonSignup = findViewById(R.id.btnLogin);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntend = new Intent(MainActivity.this,SignUp.class);
                startActivity(signupIntend);
            }
        });
        buttonSignup = findViewById(R.id.btnuUpdate);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntend = new Intent(MainActivity.this,activity_update.class);
                startActivity(signupIntend);
            }
        });
    }
}