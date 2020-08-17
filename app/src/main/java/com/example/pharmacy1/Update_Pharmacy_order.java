package com.example.pharmacy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Update_Pharmacy_order extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__pharmacy_order);
        button = (Button)findViewById(R.id.updaebtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void openActivity() {

        Intent intent = new Intent(this, Order_List.class);
        startActivity(intent);
    }
}