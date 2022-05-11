package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Activity.MessageDatabase;
import com.example.myapplication.R;

import java.util.List;

public class Fragment3_BaseAdapter extends BaseAdapter {
    private Context context;
    private List<MessageDatabase> message_list;


    public Fragment3_BaseAdapter(Context context, List<MessageDatabase> message_list) {
        this.context = context;
        this.message_list = message_list;
    }

    @Override
    public int getCount() {
        return message_list.size();
    }

    @Override
    public Object getItem(int i) {
        return message_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.fragment3_message_item, null);
            viewHolder.message_name = view.findViewById(R.id.message_name);
            viewHolder.last_message = view.findViewById(R.id.last_message);
            viewHolder.message_time = view.findViewById(R.id.message_time);
            viewHolder.header = view.findViewById(R.id.header);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        MessageDatabase message = message_list.get(i);
        viewHolder.message_name.setText((message.getMessage_name()));
        viewHolder.last_message.setText((message.getLast_message()));
        viewHolder.message_time.setText((message.getMessage_time()));
        viewHolder.header.setImageResource(message.getHeader());
        return view;
    }


    private class ViewHolder {
        TextView message_name;          //名字
        TextView last_message;          //最后一条消息
        TextView message_time;          //最后一条消息的时间
        ImageView header;               //头像
        List<String> message_detail;    //所有消息
    }
}
