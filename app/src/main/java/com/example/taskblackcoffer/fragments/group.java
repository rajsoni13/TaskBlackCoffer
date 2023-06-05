package com.example.taskblackcoffer.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.taskblackcoffer.R;
import com.example.taskblackcoffer.fragments.adapters.GroupAdapter;
import com.example.taskblackcoffer.fragments.adapters.Names;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

public class group extends Fragment {


    private ArrayList<Names> nameArrayList;
    private String[] nameHeading;
    private int[] imageResource;
    RecyclerView recyclerView;
    
    FloatingActionsMenu base;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        
        return view; 
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataIntialize();
        recyclerView = view.findViewById(R.id.listview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        GroupAdapter groupAdapter = new GroupAdapter(getContext(),nameArrayList);
        recyclerView.setAdapter(groupAdapter);
        groupAdapter.notifyDataSetChanged();
    }

    private void dataIntialize() {

        nameArrayList = new ArrayList<>();
        nameHeading = new String[]{
                getString(R.string.a),
                getString(R.string.b),
                getString(R.string.c),
                getString(R.string.d),
                getString(R.string.e),
                getString(R.string.f),
                getString(R.string.g),
                getString(R.string.h),
                getString(R.string.i),
       };
        
        imageResource = new int[]{
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.six,
                R.drawable.seven,
                R.drawable.eight,
                R.drawable.three,
        };

        for(int i=0; i<nameHeading.length; i++){
            Names names = new Names(nameHeading[i], imageResource[i]);
            nameArrayList.add(names);
        }


    }
}