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

    public Button home_button_signin;
    public Button register_button;
    public Button findback_password_button;

    Fragment_FirstPage Fragment_FirstPage = new Fragment_FirstPage();
    Fragment_PublishPage Fragment_PublishPage = new Fragment_PublishPage();
    Fragment_MessagePage Fragment_MessagePage = new Fragment_MessagePage();
    Fragment_HomePage Fragment_HomePage = new Fragment_HomePage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_button_signin=findViewById(R.id.home_button_signin);
        register_button = findViewById(R.id.register_button);
        findback_password_button = findViewById(R.id.findback_password_button);

        home_button_signin.setOnClickListener(view -> {
            Intent home_intent=new Intent(MainActivity.this,FunctionActivity.class);
            startActivity(home_intent);
        });

        register_button.setOnClickListener(view -> {
            Intent register = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(register);
        });

        findback_password_button.setOnClickListener(view -> {
            Intent findbackPassword = new Intent(MainActivity.this, FindPasswordActivity.class);
            startActivity(findbackPassword);
        });
    }



}