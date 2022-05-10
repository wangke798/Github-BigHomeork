package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Fragment.Fragment_FirstPage;
import com.example.Fragment.Fragment_HomePage;
import com.example.Fragment.Fragment_MessagePage;
import com.example.Fragment.Fragment_PublishPage;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private Button home_button_signin;

    com.example.Fragment.Fragment_FirstPage Fragment_FirstPage = new Fragment_FirstPage();
    com.example.Fragment.Fragment_PublishPage Fragment_PublishPage = new Fragment_PublishPage();
    com.example.Fragment.Fragment_MessagePage Fragment_MessagePage = new Fragment_MessagePage();
    com.example.Fragment.Fragment_HomePage Fragment_HomePage = new Fragment_HomePage();

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