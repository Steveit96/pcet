package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_welcome, txt_useName, txt_pass, txt_login;
    private EditText edt_username, edit_password;
    private LinearLayout ll_login;

    private Typeface proximaNovaReg, getProximaNovaBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_welcome=findViewById(R.id.txt_welcome);
        txt_useName=findViewById(R.id.txt_usename);
        txt_pass=findViewById(R.id.txt_pass);
        txt_login=findViewById(R.id.txt_login);
        edt_username=findViewById(R.id.edt_username);
        edit_password=findViewById(R.id.edt_pass);
        ll_login=findViewById(R.id.ll_login);

        proximaNovaReg = Typeface.createFromAsset(getAssets(), "ProximaNova-Regular.otf");
        txt_useName.setTypeface(proximaNovaReg);
        txt_pass.setTypeface(proximaNovaReg);
        edit_password.setTypeface(proximaNovaReg);
        edt_username.setTypeface(proximaNovaReg);

        getProximaNovaBold = Typeface.createFromAsset(getAssets(), "Proxima Nova Bold.otf");
        txt_welcome.setTypeface(getProximaNovaBold);
        txt_login.setTypeface(getProximaNovaBold);

        ll_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(edt_username.getText().toString().isEmpty()) {
                  Toast.makeText(getApplicationContext(), "Username is empty", Toast.LENGTH_SHORT).show();
              }else if(edit_password.getText().toString().isEmpty()) {
                  Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT).show();
              } else if (edt_username.getText().toString().trim().equals("steve@gmail.com") && edit_password.getText().toString().trim().equals("123456")) {
                      Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                      startActivity(i);
                      finish();
                  } else {
                      Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                  }

            }
        });


    }
}
