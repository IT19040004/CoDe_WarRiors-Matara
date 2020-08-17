package com.example.pharmacy1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class place_pharmacy_order extends AppCompatActivity {

    public Button button;

private static final String Tag = "place_pharmacy_order";

private TextView mDisplayDate;
 private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_pharmacy_order);
        button = (Button)findViewById(R.id.plcebtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        mDisplayDate=(TextView) findViewById(R.id.dateTxt);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal= Calendar.getInstance();
                int year= cal.get(Calendar. YEAR);
                int month= cal.get(Calendar. MONTH);
                int day= cal.get(Calendar. DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        place_pharmacy_order.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                        dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Log.d(Tag,"onDateSet: date:" + i + "/" +i1+ "/" +i2);
            }
        };
    }
    public void openActivity(){

        Intent intent = new Intent(this,Order_List.class);
        startActivity(intent);}
}