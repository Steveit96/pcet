package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    public ArrayList<String> listYear = new ArrayList<>();
    public ArrayList<String> listBatch = new ArrayList<>();
    TextView tv_title;
    Typeface getProximaNovaBold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_title=findViewById(R.id.tv_title);
        getProximaNovaBold = Typeface.createFromAsset(getAssets(), "Proxima Nova Bold.otf");
        tv_title.setTypeface(getProximaNovaBold);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_home);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        listYear.add("1st year");
        listYear.add("2nd year");
        listYear.add("3rd year");
        listYear.add("Final year");
        listYear.add("Staffs");
        listBatch.add("2015-2019");
        listBatch.add("2016-2020");
        listBatch.add("2017-2021");
        listBatch.add("2018-2022");
        listBatch.add("IT Department");
        HomeAdapter adapter = new HomeAdapter(HomeActivity.this, listYear,listBatch);
        recyclerView.setAdapter(adapter);
    }

}
