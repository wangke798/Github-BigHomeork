package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.activity.MessageDatabase;
import com.example.adapter.Fragment3BaseAdapter;
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
    private int header = R.drawable.header;
    private MessageDatabase message;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3,container,false);

        fragment3_listview = view.findViewById(R.id.fragment3_listview);
        for(int i = 0; i < 30; i ++){
            if(i % 2 == 0){
                message = new MessageDatabase(message_name[0],message_detail[0],header);
            } else{
                message = new MessageDatabase(message_name[1],message_detail[1],header);
            }
            list.add(message);
        }

        Fragment3BaseAdapter baseAdapter = new Fragment3BaseAdapter(fragment3_listview.getContext(), list);
        fragment3_listview.setAdapter(baseAdapter);
        fragment3_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });


        return view;
    }
}
