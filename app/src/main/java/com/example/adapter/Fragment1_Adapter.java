package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;

import java.util.List;
import java.util.Map;

public class Fragment1_Adapter extends SimpleAdapter {
    private Context context;

    public void setIndex(int index) {
        this.index = index;
    }

    private int index=-1;
    public Fragment1_Adapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        view.setBackgroundColor(context.getResources().getColor(R.color.white));

        return view;
    }
}