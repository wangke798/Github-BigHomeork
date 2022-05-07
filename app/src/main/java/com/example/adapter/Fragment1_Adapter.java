package com.example.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.optimization.Tasks;

import java.util.List;

public class Fragment1_Adapter extends BaseAdapter{
    private Context context;
    private List<Tasks> datas;
    public Fragment1_Adapter(Context context,List<Tasks>datas){
        this.context=context;
        this.datas=datas;
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Tasks tak=(Tasks) getItem(i);
        View v;
        ViewHold viewHold;
        if(view==null){
            v= LayoutInflater.from(context).inflate(R.layout.fragment1_listview,null);
            viewHold=new ViewHold();
            viewHold.photo=v.findViewById(R.id.myphoto);
            viewHold.text=v.findViewById(R.id.mytextview);
            viewHold.text1=v.findViewById(R.id.mytextview1);
            viewHold.text2=v.findViewById(R.id.mytextview2);
            viewHold.mybutton=v.findViewById(R.id.mybutton);

            v.setTag(viewHold);

        }else{
            v=view;
            viewHold=(ViewHold) v.getTag();

        }
        viewHold.photo.setImageResource(tak.getPhoto());
        viewHold.text.setText(tak.getText());
        viewHold.text1.setText(tak.getText1());
        viewHold.text2.setText(tak.getText2());
        viewHold.mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog alertDialog1 = new AlertDialog.Builder(context).create();
                alertDialog1.setIcon(R.drawable.caution);
                alertDialog1.setTitle("温馨提示");
                alertDialog1.setMessage("您确定要接受这个任务吗？");;
                alertDialog1.setButton(DialogInterface.BUTTON_POSITIVE, "确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "您接受了任务", Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog1.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "您取消了接收任务", Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog1.show();

            }
        });
        return v;
    }
}

class ViewHold{
    ImageView photo;
    TextView text;
    TextView text1;
    TextView text2;
    Button mybutton;
}