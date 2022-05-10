package com.example.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.adapter.Fragment1_Adapter;
import com.example.myapplication.R;
import com.example.optimization.Tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Fragment_FirstPage extends Fragment {

    private ListView mylistview;
    private List<Tasks> datas=new ArrayList<Tasks>();
    private Fragment1_Adapter adapter1;

    public String[] text = {
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
    public String[] text1 = {
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
    public String[] text2 = {
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
    public int[] photo = {
            R.drawable.photo,
            R.drawable.photo1,
            R.drawable.photo2,
            R.drawable.photo3,
            R.drawable.photo4,
            R.drawable.photo5,
            R.drawable.photo6,
            R.drawable.photo7,
            R.drawable.photo8};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View fragmentView = inflater.inflate(R.layout.fragment1, container,false);

        initDatas();//初始化数据
        mylistview=(ListView)fragmentView.findViewById(R.id.mylistview);
        adapter1=new Fragment1_Adapter(getActivity(),datas);
        mylistview.setAdapter(adapter1);

    return fragmentView;

    }
    private void initDatas(){
        for(int i=0;i<text.length;i++){
            Tasks task=new Tasks(text[i],text1[i],text2[i],photo[i]);
            datas.add(task);
        }


    }
}