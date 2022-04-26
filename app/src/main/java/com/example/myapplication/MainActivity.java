package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button home_button_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_button_signin=findViewById(R.id.home_button_signin);
        home_button_signin.setOnClickListener(view -> {
            Intent home_intent=new Intent(MainActivity.this,FunctionActivity.class);
            startActivity(home_intent);
        });
    }
}