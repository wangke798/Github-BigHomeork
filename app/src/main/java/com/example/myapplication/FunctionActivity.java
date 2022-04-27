package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FunctionActivity extends AppCompatActivity {
    private TextView function_imageview;
    private TextView function_imageview1;
    private TextView function_imageview2;
    private TextView function_imageview3;
    FragmentTransaction function_fragmenttransaction=getSupportFragmentManager().beginTransaction();
    Fragment function_fragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuction);

        function_imageview=findViewById(R.id.function_imageview);
        function_imageview1=findViewById(R.id.function_imageview1);
        function_imageview2=findViewById(R.id.function_imageview2);
        function_imageview3=findViewById(R.id.function_imageview3);

        function_imageview.setOnClickListener(function_listener);
        function_imageview1.setOnClickListener(function_listener);
        function_imageview2.setOnClickListener(function_listener);
        function_imageview3.setOnClickListener(function_listener);
        function_fragment=new HomePageFragment();
        function_fragmenttransaction.add(R.id.function_framelayout,function_fragment);
        function_fragmenttransaction.commit();
    }

    //重置所有文本的选中状态
    public void selected(){
        function_imageview.setSelected(false);
        function_imageview1.setSelected(false);
        function_imageview2.setSelected(false);
        function_imageview3.setSelected(false);
    }


    View.OnClickListener function_listener= view -> {
        switch (view.getId()){
            case R.id.function_imageview:
                selected();
                function_imageview.setSelected(true);           //使点击的状态览变化
                function_fragment=new HomePageFragment();
                break;
            case R.id.function_imageview1:
                selected();
                function_imageview1.setSelected(true);
                function_fragment=new PublishFragment();
                break;
            case R.id.function_imageview2:
                selected();
                function_imageview2.setSelected(true);
                function_fragment=new MessageFragment();
                break;
            case R.id.function_imageview3:
                selected();
                function_imageview3.setSelected(true);
                function_fragment=new MyFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.function_framelayout,function_fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commitAllowingStateLoss();
    };

}