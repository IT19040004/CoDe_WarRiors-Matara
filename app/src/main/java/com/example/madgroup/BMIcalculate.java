package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIcalculate extends AppCompatActivity {

     Button btnCalc;
     EditText edtHeight;
     EditText edtWeight;

    TextView resultBmi,BMIvalue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_icalculate);

        btnCalc = (Button)findViewById(R.id.btnCalc);
        edtHeight = (EditText)findViewById(R.id.edtTxtHgt);
        edtWeight = (EditText)findViewById(R.id.edtTxtWeight);
        resultBmi = (TextView)findViewById(R.id.textViewBMI);
        BMIvalue = (TextView)findViewById(R.id.textViewBMIValue);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              calcBMI();
            }


        });
    }

    //BMI calculate
    public void calcBMI(){



       Float weight = Float.parseFloat(edtWeight.getText().toString());
       Float height=Float.parseFloat(edtHeight.getText().toString());

        Float result = weight/(height * height);

        resultBmi.setText(String.valueOf(result));


        if(result>=25.0){
            BMIvalue.setText("Overweight");
        }
        else if(result<18.0) {
            BMIvalue.setText("...Thin...");
        }
        else{
            BMIvalue.setText("Healthy Weight");
        }
    }


}