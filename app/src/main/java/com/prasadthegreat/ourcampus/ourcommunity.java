package com.prasadthegreat.ourcampus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ourcommunity extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ourcommunity() {

    }


    public static ourcommunity newInstance(String param1, String param2) {
        ourcommunity fragment = new ourcommunity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_ourcommunity, container, false);

        getFragmentManager().beginTransaction().replace(R.id.dashboardcontainer,new Imagesfragment()).commit();

        Button imagebtn=(Button)view.findViewById(R.id.imagebtn);
        Button videobtn=(Button)view.findViewById(R.id.videobtn);
        Button mhelp=(Button)view.findViewById(R.id.helpbtn);

        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new Imagesfragment();
                getFragmentManager().beginTransaction().replace(R.id.dashboardcontainer,fragment).commit();
            }
        });

        videobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new videosfragment();
                getFragmentManager().beginTransaction().replace(R.id.dashboardcontainer,fragment).commit();
            }
        });

        mhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new helpcommunityfragment();
                getFragmentManager().beginTransaction().replace(R.id.dashboardcontainer,fragment).commit();
            }
        });

        return view;

    }
}