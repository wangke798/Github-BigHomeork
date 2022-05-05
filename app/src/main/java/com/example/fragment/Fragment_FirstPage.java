package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.Adapter.Fragment1_Adapter;
import com.example.activity.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_FirstPage extends Fragment  {

    public Button mybutton;
    public ListView mylistview;
    public List<Map<String,Object>> listsimple=new ArrayList();
    public String[] text={
            "送快递",
            "送外卖",
            "送花",
            "送电脑",
            "送充电器",
            "送充电宝",
            "送蜜雪冰城",
            "送手机",
            "送校园卡"
    };
    public String[] text1={
            "将包裹送到河南大学东苑宿舍",
            "将外卖送到东苑宿舍20号楼",
            "将花送到东苑宿舍19号楼",
            "将电脑送到东苑宿舍18号楼",
            "将充电器送到今明综合楼1101",
            "将充电宝送到今明综合楼2104",
            "将蜜雪冰城送到计算机学院201",
            "将手机送到计算机学院512",
            "将校园卡送到计算机学院114"
    };
    public String[] text2={
            "费用：10元",
            "费用：2元",
            "费用：5元",
            "费用：10元",
            "费用：7元",
            "费用：14元",
            "费用：25元",
            "费用：31元",
            "费用：17元"
    };
    public String[] button={"接受"};
    public int[] photo={R.drawable.photo,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8};
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);    //这是生命周期中的函数，经常是把初始数据写在这里
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for(int i=0;i<text.length;i++){
            Map<String,Object> item=new HashMap<>();
            item.put("text",text[i]);
            item.put("text1",text1[i]);
            item.put("text2",text2[i]);
            item.put("button",button[0]);
            item.put("photo",photo[i]);
            listsimple.add(item);
        }
        View fragmentView= inflater.inflate(R.layout.fragment1, container, false);
        mylistview=fragmentView.findViewById(R.id.mylistview);
        mybutton=fragmentView.findViewById(R.id.mybutton);

        //将文字填入listview中
        Fragment1_Adapter simpleAdapter=new Fragment1_Adapter(getActivity(),listsimple,R.layout.fragment1_listview,
                new String[]{"text","text1","text2","button","photo"},
                new int[]{R.id.mytextview,R.id.mytextview1,R.id.mytextview2,R.id.mybutton,R.id.myphoto});

        mylistview.setAdapter(simpleAdapter);

        //listview中的点击事件

        return fragmentView;
    }

}