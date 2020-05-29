package com.example.sampleapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter {

    public ArrayList<String> listName = new ArrayList<>();
    public ArrayList<String> listRollNo = new ArrayList<>();
    Context context;

    public StudentAdapter(Context context, ArrayList<String> listName, ArrayList<String> listRollNo) {
        this.listName = listName;
        this.listRollNo = listRollNo;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
            ((MyViewHolder) holder).iv_icon.setImageResource(R.drawable.ic_avatar);
            ((MyViewHolder) holder).txt_year.setText(listName.get(position));
            ((MyViewHolder) holder).txt_batch.setText(listRollNo.get(position));
        }catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return listName.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year, txt_batch;
        ImageView iv_icon;
        private Typeface proximaNovaReg, getProximaNovaBold;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_year = (TextView) itemView.findViewById(R.id.tv_year);
            txt_batch = (TextView) itemView.findViewById(R.id.tv_batch);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            proximaNovaReg = Typeface.createFromAsset(context.getAssets(), "ProximaNova-Regular.otf");
            getProximaNovaBold = Typeface.createFromAsset(context.getAssets(), "Proxima Nova Bold.otf");
            txt_year.setTypeface(getProximaNovaBold);
            txt_batch.setTypeface(proximaNovaReg);
        }
    }
}