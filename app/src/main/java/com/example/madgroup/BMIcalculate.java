package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BMIcalculate extends AppCompatActivity {

    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_icalculate);

        btnCalc = (Button)findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirst();
            }
        });
    }
    public void openFirst(){
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }
}