package com.prasadthegreat.ourcampus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    View homeview;
    RecyclerView mrecyclerView;
    homeadapterclass myadapter;
    private String mParam1;
    private String mParam2;

    public Home() {

    }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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

        View homeview= inflater.inflate(R.layout.fragment_home, container, false);
         mrecyclerView = (RecyclerView) homeview.findViewById(R.id.homerecyclerview);


        mrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<homemodel> options =
                new FirebaseRecyclerOptions.Builder<homemodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("tasklist"), homemodel.class)
                        .build();
        myadapter=new homeadapterclass(options);
        mrecyclerView.setAdapter(myadapter);
        return homeview;
    }

    @Override
    public void onStart() {
        super.onStart();
        myadapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        myadapter.stopListening();
    }
}