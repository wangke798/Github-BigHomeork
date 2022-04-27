package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FunctionActivity extends AppCompatActivity {
    private TextView function_textview1;
    private TextView function_textview2;
    private TextView function_textview3;
    private TextView function_textview4;
    FragmentTransaction function_fragmenttransaction=getSupportFragmentManager().beginTransaction();
    Fragment function_fragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuction);

        function_textview1=findViewById(R.id.function_imageview1);
        function_textview2=findViewById(R.id.function_imageview2);
        function_textview3=findViewById(R.id.function_imageview3);
        function_textview4=findViewById(R.id.function_imageview4);

        function_textview1.setOnClickListener(function_listener);
        function_textview2.setOnClickListener(function_listener);
        function_textview3.setOnClickListener(function_listener);
        function_textview4.setOnClickListener(function_listener);
        function_fragment=new Fragment1();
        function_fragmenttransaction.add(R.id.function_framelayout,function_fragment);
        function_fragmenttransaction.commit();
    }

    //重置所有文本的选中状态
    public void selected(){
        function_textview1.setSelected(false);
        function_textview2.setSelected(false);
        function_textview3.setSelected(false);
        function_textview4.setSelected(false);
    }


    View.OnClickListener function_listener= view -> {
        switch (view.getId()){
            case R.id.function_imageview1:
                selected();
                function_textview1.setSelected(true);           //使点击的状态览变化
                function_fragment=new Fragment1();
                break;
            case R.id.function_imageview2:
                selected();
                function_textview2.setSelected(true);
                function_fragment=new Fragment2();
                break;
            case R.id.function_imageview3:
                selected();
                function_textview3.setSelected(true);
                function_fragment=new Fragment3();
                break;
            case R.id.function_imageview4:
                selected();
                function_textview4.setSelected(true);
                function_fragment=new Fragment4();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.function_framelayout,function_fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitAllowingStateLoss();
    };

}