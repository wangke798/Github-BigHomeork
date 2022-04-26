package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FunctionActivity extends AppCompatActivity {
    private ImageView fuction_imageview;
    private ImageView fuction_imageview1;
    private ImageView fuction_imageview2;
    private ImageView fuction_imageview3;
    FragmentManager fuction_fragmentmanager=getSupportFragmentManager();
    FragmentTransaction fuction_fragmenttransaction=fuction_fragmentmanager.beginTransaction();
    Fragment fuction_fragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuction);

        fuction_imageview=findViewById(R.id.fuction_imageview);
        fuction_imageview1=findViewById(R.id.fuction_imageview1);
        fuction_imageview2=findViewById(R.id.fuction_imageview2);
        fuction_imageview3=findViewById(R.id.fuction_imageview3);

        fuction_imageview.setOnClickListener(function_listener);
        fuction_imageview1.setOnClickListener(function_listener);
        fuction_imageview2.setOnClickListener(function_listener);
        fuction_imageview3.setOnClickListener(function_listener);
        fuction_fragment=new MyFragment();
        fuction_fragmenttransaction.add(R.id.fuction_framelayout,fuction_fragment);
        fuction_fragmenttransaction.commit();
    }

    View.OnClickListener function_listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.fuction_imageview:
                    fuction_fragment=new MyFragment();
                    break;
                case R.id.fuction_imageview1:
                    fuction_fragment=new MyFragment1();
                    break;
                case R.id.fuction_imageview2:
                    fuction_fragment=new MyFragment2();
                    break;
                case R.id.fuction_imageview3:
                    fuction_fragment=new MyFragment3();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fuction_framelayout,fuction_fragment, "fragment")
                    .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitAllowingStateLoss();
        }
    };

}
