package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.Adapter.Fragment1_Adapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_FirstPage extends Fragment  {

    private ListView  mylistview;
    private List<Map<String,Object>> listsimple=new ArrayList();
    private String[] text={"任务1","任务2","任务3","任务4","任务5","任务6",};
    private String[] text1={"任务内容1","任务内容2","任务内容3","任务内容4","任务内容5","任务内容6",};
    private String[] button={"接受"};
    private int[] photo={R.drawable.wangke};
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);    //这是生命周期中的函数，经常是把初始数据写在这里
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for(int i=0;i<text.length;i++){
            Map<String,Object> item=new HashMap<>();
            item.put("text",text[i]);
            item.put("text1",text1[i]);
            item.put("button",button[0]);
            item.put("photo",photo[0]);
            listsimple.add(item);
        }
        View fragmentView= inflater.inflate(R.layout.fragment1, container, false);
        mylistview=fragmentView.findViewById(R.id.mylistview);
        Fragment1_Adapter simpleAdapter=new Fragment1_Adapter(getActivity(),listsimple,R.layout.fragment1_listview,
                new String[]{"text","text1","button","photo"},new int[]{R.id.mytextview,R.id.mytextview1,R.id.mybutton,R.id.myphoto});
        mylistview.setAdapter(simpleAdapter);
        mylistview.setOnItemClickListener((adapterView, view, i, l) -> {
            Map<String,Object> temp=listsimple.get(i);
            simpleAdapter.setIndex(i);
            simpleAdapter.notifyDataSetChanged();
            Toast.makeText(getActivity(),temp.get("text").toString(),Toast.LENGTH_SHORT).show();
        });
        return fragmentView;
    }
}