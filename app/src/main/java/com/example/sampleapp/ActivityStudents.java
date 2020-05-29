package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityStudents extends AppCompatActivity {

    public ArrayList<String> listStudName = new ArrayList<>();
    public ArrayList<String> listStudRollno = new ArrayList<>();
    Typeface getProximaNovaBold;
    TextView tv_title;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.purple));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        type=getIntent().getExtras().get("type").toString();
        tv_title=findViewById(R.id.tv_title);
        getProximaNovaBold = Typeface.createFromAsset(getAssets(), "Proxima Nova Bold.otf");
        tv_title.setTypeface(getProximaNovaBold);
        tv_title.setText("IT DPET "+type);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        if(type.equals("Staffs")){
            listStudName.add("Vijaya Laxmi");
            listStudName.add("Siva");
            listStudName.add("Mohan");
            listStudName.add("Suseela");
            listStudName.add("Kavitha");
            listStudName.add("Deepak");
            listStudName.add("AmudhaValli");
            listStudRollno.add("HOD");
            listStudRollno.add("Assistant HOD");
            listStudRollno.add("Tutor");
            listStudRollno.add("Senior Staff");
            listStudRollno.add("Senior Staff");
            listStudRollno.add("Senior Staff");
            listStudRollno.add("Senior Staff");
        }else{
            listStudName.add("Ameera");
            listStudName.add("Gowthem");
            listStudName.add("Monika");
            listStudName.add("Naveen");
            listStudName.add("Siva Ranjani");
            listStudName.add("Sahana");
            listStudName.add("Siva Vignesh");
            listStudName.add("Stephan");
            listStudName.add("Sunil");
            listStudName.add("Jafer");
            listStudRollno.add("14IT001");
            listStudRollno.add("14IT002");
            listStudRollno.add("14IT003");
            listStudRollno.add("14IT005");
            listStudRollno.add("14IT007");
            listStudRollno.add("14IT008");
            listStudRollno.add("14IT009");
            listStudRollno.add("14IT0010");
            listStudRollno.add("14IT0011");
            listStudRollno.add("14IT0012");
        }
        StudentAdapter adapter = new StudentAdapter(ActivityStudents.this, listStudName,listStudRollno);
        recyclerView.setAdapter(adapter);
    }
}
