package com.example.Activity;


import android.app.Activity;
import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.Adapter.MsgAdapter;
import com.example.myapplication.R;
import com.example.optimization.CircleImage;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends Activity {

    private ListView listView;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList = new ArrayList<Msg>();
    private EditText input;         //输入框
    private Button send;            //发送按钮
    private Button fanhui;          //返回按钮
    private TextView textView_name; //对方的名字
    private int  header_left;        //左边对方的头像
    private int header_right;       //右边自己的头像
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        //返回按钮 添加监听事件
        fanhui = findViewById(R.id.fanhui_btn);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(1,intent);
                finish();
            }
        });

        //消息记录 设置
        listView = (ListView) findViewById(R.id.msg_list_view);
        initMsg();
        msgAdapter  = new MsgAdapter(this, R.layout.chat_msg_item, msgList);
        listView.setAdapter(msgAdapter);
        listView.setSelection(msgList.size() - 1);
        input = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = input.getText().toString();
                if(!"".equals(message)) {
                    Msg msg = new Msg(message, Msg.MSG_SEND, header_left,header_right);
                    msgList.add(msg);
                    msgAdapter.notifyDataSetChanged();//当有新消息时刷新
                    listView.setSelection(msgList.size() - 1);
                }else {
                    Toast.makeText(ChatActivity.this, "input can't be empty", Toast.LENGTH_SHORT).show();
                }
                input.setText("");
            }
        });
    }

    //聊天界面初始化
    private void initMsg() {
        //接收数据
        bundle = this.getIntent().getExtras();

        //头像初始化
        header_left = bundle.getInt("header");
        header_right = R.drawable.photo3;


        //名字初始化
        textView_name = findViewById(R.id.chat_name);
        String name = bundle.getString("name");
        textView_name.setText(name);

        //聊天记录初始化
        Msg msg;
        msg = new Msg("Hi, boy", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("Hi, girl", Msg.MSG_SEND,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("what's up", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("1", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("2", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("3", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("4", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("5", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("6", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("7", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("8", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("9", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("10", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("11", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("12", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);
        msg = new Msg("13", Msg.MSG_RECEIVE,header_left,header_right);
        msgList.add(msg);



    }
}