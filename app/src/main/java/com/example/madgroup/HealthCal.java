package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthCal extends AppCompatActivity {

    private Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_cal);

        btn = (Button)findViewById(R.id.btnCalBMI);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBMIcalculation();
            }
        });
        btn2=findViewById(R.id.btnBMR);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBMRcalculattion();
            }
        });
    }

    public void openBMIcalculation(){
        Intent intent = new Intent(this, BMIcalculate.class);
        startActivity(intent);
    }
    public void openBMRcalculattion(){
        Intent intent = new Intent(this, BMR_Calculator.class);
        startActivity(intent);
    }
}