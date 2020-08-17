package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.view.View;
import android.widget.Button;

public class PatientHome extends AppCompatActivity {

    private Button bt;
    private Button btLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

         btLab= (Button)findViewById(R.id.btnLab);
         btLab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openLab();
             }
         });

        bt = (Button)findViewById(R.id.btnCal);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHealCal();
            }
        });
    }
    public void openHealCal(){
        Intent intent = new Intent(this, HealthCal.class);
        startActivity(intent);

    }

    public void openLab(){
        Intent intent = new Intent(this, LabChemistList.class);
        startActivity(intent);

    }
}