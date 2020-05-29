package com.example.sampleapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {

    public static int[] imageList = {R.drawable.ic_one, R.drawable.ic_two, R.drawable.ic_three, R.drawable.ic_four, R.drawable.ic_avatar};
    public ArrayList<String> listYear = new ArrayList<>();
    public ArrayList<String> listBatch = new ArrayList<>();
    Context context;

    public HomeAdapter(Context context,ArrayList<String> listYear, ArrayList<String> listBatch) {
        this.listYear = listYear;
        this.listBatch = listBatch;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        try {
            ((MyViewHolder) holder).iv_icon.setImageResource(imageList[position]);
            ((MyViewHolder) holder).txt_year.setText(listYear.get(position));
            ((MyViewHolder) holder).txt_batch.setText(listBatch.get(position));
            ((MyViewHolder) holder).rv_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, ActivityStudents.class);
                    i.putExtra("type",listYear.get(position));
                    context.startActivity(i);
                }
            });
        }catch (Exception e){
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_year, txt_batch;
        ImageView iv_icon;
        RelativeLayout rv_layout;
        private Typeface proximaNovaReg, getProximaNovaBold;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_year = (TextView) itemView.findViewById(R.id.tv_year);
            txt_batch = (TextView) itemView.findViewById(R.id.tv_batch);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            rv_layout = (RelativeLayout) itemView.findViewById(R.id.rv_layout);
            proximaNovaReg = Typeface.createFromAsset(context.getAssets(), "ProximaNova-Regular.otf");
            getProximaNovaBold = Typeface.createFromAsset(context.getAssets(), "Proxima Nova Bold.otf");
            txt_year.setTypeface(getProximaNovaBold);
            txt_batch.setTypeface(proximaNovaReg);
        }
    }
}