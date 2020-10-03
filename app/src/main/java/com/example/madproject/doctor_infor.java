package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class doctor_infor extends AppCompatActivity {

    Button dMyUpdateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_infor);

        dMyUpdateAccount = findViewById(R.id.dMyUpdateAccount);

        dMyUpdateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Update_doctor_profile.class);
                startActivity(i);
            }
        });
    }
}