package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthCal extends AppCompatActivity {

    private Button btn;

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
    }

    public void openBMIcalculation(){
        Intent intent = new Intent(this, BMIcalculate.class);
        startActivity(intent);
    }
}