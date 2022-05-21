package com.example.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class Fragment_HomePage extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment4, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton myset = (ImageButton) getActivity().findViewById(R.id.myset);
        myset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragment_homepage_set=new Intent();
                fragment_homepage_set.setClass(getActivity(),Fragment_HomePage_Set.class);
                startActivity(fragment_homepage_set);
            }
        });

        TextView mywallet = (TextView)getActivity().findViewById(R.id.mywallet);
        mywallet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fragment_homepage_wallet=new Intent();
                fragment_homepage_wallet.setClass(getActivity(),Fragment_HomePage_Wallet.class);
                startActivity(fragment_homepage_wallet);
            }
        });

        TextView mytask = (TextView)getActivity().findViewById(R.id.mytask);
        mytask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent fragment_homepage_task=new Intent();
                fragment_homepage_task.setClass(getActivity(),Fragment_HomePage_Task.class);
                startActivity(fragment_homepage_task);
            }
        });

    }
}
