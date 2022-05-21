package com.example.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.Activity.ChatActivity;
import com.example.Activity.MessageDatabase;
import com.example.Adapter.Fragment3_BaseAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_MessagePage extends Fragment {
    private ListView fragment3_listview;
    private List<MessageDatabase> list = new ArrayList<>();
    private String[] message_name = {
            "彤雨晴",
            "萧南莲",
            "宋宝宝",
            "影伴人久",
            "弘香薇",
            "祁玲玲",
            "李念瑶",
            "席振华",
            "藏怀幕",
            "青衫烟雨客",
            "公孙如雪"};
    private String[] last_message = {
            "你好啊！",
            "hhhh",
            "在吗？",
            "你要帮我送外卖吗？",
            "将花送到东苑宿舍19号楼，可以吗？",
            "来送电脑啦！",
            "哈哈哈,你好帅啊！",
            "饮料好喝吗？",
            "确定实在201吗？",
            "嘿,小伙子手机不错啊！",
            "来了,来了!"};
    private String[] message_time = {
            "2021年10月1日",
            "10:21",
            "昨天",
            "8:11",
            "9月11日",
            "10::10",
            "10:21",
            "前天",
            "0:11",
            "4月10日",
            "2019年12月19日",
            "2020年6月1日",};
    private int header[] = {
            R.drawable.photo,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8,
            R.drawable.photo9,
            R.drawable.photo10,
    };
    private MessageDatabase message;
    private Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3,container,false);


        //将message添加到list中
        fragment3_listview = view.findViewById(R.id.fragment3_listview);
        for(int i = 0; i < 11; i ++){
                message = new MessageDatabase(message_name[i],last_message[i],message_time[i],header[i]);
                list.add(message);
        }

        //为页面添加baseAdapter
        Fragment3_BaseAdapter baseAdapter = new Fragment3_BaseAdapter(fragment3_listview.getContext(), list);
        fragment3_listview.setAdapter(baseAdapter);
        fragment3_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(getActivity(), ChatActivity.class);
                String name = list.get(i).getMessage_name();
                int header = list.get(i).getHeader();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putInt("header",header);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
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
