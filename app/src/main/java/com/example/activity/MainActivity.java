package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment.Fragment_FirstPage;
import com.example.fragment.Fragment_HomePage;
import com.example.fragment.Fragment_MessagePage;
import com.example.fragment.Fragment_PublishPage;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button home_button_signin;

    com.example.fragment.Fragment_FirstPage Fragment_FirstPage = new Fragment_FirstPage();
    com.example.fragment.Fragment_PublishPage Fragment_PublishPage = new Fragment_PublishPage();
    com.example.fragment.Fragment_MessagePage Fragment_MessagePage = new Fragment_MessagePage();
    com.example.fragment.Fragment_HomePage Fragment_HomePage = new Fragment_HomePage();

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