package com.example.taskblackcoffer.fragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskblackcoffer.R;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {

    Context context;
    ArrayList<Names> namesArrayList;

    public GroupAdapter(Context context, ArrayList<Names> namesArrayList) {
        this.context = context;
        this.namesArrayList = namesArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.listitemgroup,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Names names = namesArrayList.get(position);
        holder.name.setText(names.userName);
        holder.img.setImageResource(names.userImage);

    }

    @Override
    public int getItemCount() {
        return namesArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name;

        public MyViewHolder(@NonNull View itemview){
            super(itemview);
            img = itemview.findViewById(R.id.img_profile);
            name = itemview.findViewById(R.id.name);
        }
    }

}
