package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customerHome extends AppCompatActivity {

    Button dcsignout,dmyprofile,dbMyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        dcsignout = findViewById(R.id.dcsignout);
        dmyprofile = findViewById(R.id.dmyprofile);
        dbMyAccount = findViewById(R.id.dbMyAccount);

        dcsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        dmyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),customer_profile_infor.class);
                startActivity(i);
            }
        });

        dbMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Customer_Profile.class);
                startActivity(i);
            }
        });
    }
}