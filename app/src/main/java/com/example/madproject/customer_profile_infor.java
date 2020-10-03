package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customer_profile_infor extends AppCompatActivity {

    Button dMyUpAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile_infor);

        dMyUpAccount = findViewById(R.id.dMyUpdateAccount);

        dMyUpAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),update_customer_profile.class);
                startActivity(i);
            }
        });
    }
}