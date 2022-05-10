package com.example.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.activity.MessageDatabase;
import com.example.adapter.Fragment3_BaseAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_MessagePage extends Fragment {
    private ListView fragment3_listview;
    private List<MessageDatabase> list = new ArrayList<>();
    private String[] message_name = {"张三","李四"};
    private String[] last_message = {"你好啊！","hhhh"};
    private String[] message_time = {"2021年10月1日","10:21"};
    private int header1 = R.drawable.header;
    private int header2 = R.drawable.header2;
    private MessageDatabase message;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3,container,false);


        //将message添加到list中
        fragment3_listview = view.findViewById(R.id.fragment3_listview);
        for(int i = 0; i < 30; i ++){
            if(i % 2 == 0){
                message = new MessageDatabase(message_name[0],last_message[0],message_time[0],header1);
            } else{
                message = new MessageDatabase(message_name[1],last_message[1],message_time[1],header2);
            }
            list.add(message);
        }

        //为页面添加baseAdapter
        Fragment3_BaseAdapter baseAdapter = new Fragment3_BaseAdapter(fragment3_listview.getContext(), list);
        fragment3_listview.setAdapter(baseAdapter);
        fragment3_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }

        });

        fragment3_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(fragment3_listview.getContext());
                builder.setTitle("提示")
                        .setMessage("确定删除吗？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(position);
                                baseAdapter.notifyDataSetChanged();
                                Toast.makeText(getContext(),"已删除",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create().show();
                return true;
            }
        });


        return view;
    }


}
