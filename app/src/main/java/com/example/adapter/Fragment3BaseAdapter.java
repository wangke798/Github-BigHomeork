package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.activity.MessageDatabase;
import com.example.myapplication.R;

import java.util.List;

public class Fragment3BaseAdapter extends BaseAdapter {
    private Context context;
    private List<MessageDatabase> message_list;


    public Fragment3BaseAdapter(Context context,List<MessageDatabase> message_list) {
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
            viewHolder.message_detail = view.findViewById(R.id.message_detail);
            viewHolder.header = view.findViewById(R.id.header);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        MessageDatabase message = message_list.get(i);
        viewHolder.message_name.setText((message.getMessage_name()));
        viewHolder.message_detail.setText((message.getMessage_detail()));
        viewHolder.header.setImageResource(message.getHeader());

        return view;
    }


    class ViewHolder {
        TextView message_name;
        TextView message_detail;
        ImageView header;
    }
}
