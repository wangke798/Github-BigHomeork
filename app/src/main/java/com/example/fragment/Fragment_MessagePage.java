package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.activity.MessageDatabase;
import com.example.Adapter.Fragment3_BaseAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_MessagePage extends Fragment {
    private ListView fragment3_listview;
    private List<MessageDatabase> list = new ArrayList<>();
    private String[] message_name = {"张三","李四","张三","李四","张三","李四",
            "张三","李四","张三","李四","张三","李四"};
    private String[] message_detail = {"你好啊！","hhhh","你好啊！","hhhh",
            "你好啊！","hhhh","你好啊！","hhhh","你好啊！","hhhh"};
    private int header1 = R.drawable.header;
    private int header2 = R.drawable.header2;
    private MessageDatabase message;
    private DrawerLayout drawerLayout;
    private LinearLayout view_left;
    private LinearLayout view_right;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3,container,false);


        //将message添加到list中
        fragment3_listview = view.findViewById(R.id.fragment3_listview);
        for(int i = 0; i < 30; i ++){
            if(i % 2 == 0){
                message = new MessageDatabase(message_name[0],message_detail[0],header1);
            } else{
                message = new MessageDatabase(message_name[1],message_detail[1],header2);
            }
            list.add(message);
        }


        //添加滑动事件
//        drawerLayout = view.findViewById(R.id.DrawLayout);
//        view_left = view.findViewById(R.id.view_left);
//        view_right = view.findViewById(R.id.view_right);
//        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//
//
//                view_left.setTranslationX(-(drawerView.getMeasuredWidth()*(slideOffset)));
//            }
//
//            @Override
//            public void onDrawerOpened(@NonNull View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(@NonNull View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        });

        //为页面添加baseAdapter
        Fragment3_BaseAdapter baseAdapter = new Fragment3_BaseAdapter(fragment3_listview.getContext(), list);
        fragment3_listview.setAdapter(baseAdapter);
        fragment3_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });


        return view;
    }
}
