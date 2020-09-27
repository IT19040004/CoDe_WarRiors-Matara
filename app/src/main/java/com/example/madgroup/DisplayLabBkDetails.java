package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class DisplayLabBkDetails extends AppCompatActivity {

    private EditText namePatient,chemId,date,time,email,contactNumb;
    private Button update,delete,datePick,timePick;

    private int mYear,mMonth,mDay,mHour,mMinuiute;

    private String key;
    private String name,dateLab,timeLab,emailLab,labChem,contactN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lab_bk_details);

        //get Vaiues comming from the intent
        key = getIntent().getStringExtra("key");
        name = getIntent().getStringExtra("name");
        labChem = getIntent().getStringExtra("chemId");
        dateLab = getIntent().getStringExtra("date");
        timeLab = getIntent().getStringExtra("time");
        emailLab = getIntent().getStringExtra("email");
        contactN = getIntent().getStringExtra("contactNumb");



        namePatient =(EditText)findViewById(R.id.etxtPnameShowDetails);
        chemId =(EditText)findViewById(R.id.edtTextLabChemIdShowDetails);
        date =(EditText)findViewById(R.id.edtextdatePickerShowDetails);
        time =(EditText)findViewById(R.id.edttxtTimePickerShowDetails);
        email =(EditText)findViewById(R.id.etxtEmailAddressShowDetails);
        contactNumb =(EditText)findViewById(R.id.editTextPhoneShowDetails);

        //set values coming from the intent into edit texts
        namePatient.setText(name);
        chemId.setText(labChem);
        date.setText(dateLab);
        time.setText(timeLab);
        email.setText(emailLab);
        contactNumb.setText(contactN);



        update = (Button)findViewById(R.id.btnUpdate);
        delete = (Button)findViewById(R.id.btnDelete);
        datePick = (Button)findViewById(R.id.btnDatePickerShowDetails);
        timePick = (Button)findViewById(R.id.btnTimePickerShowDetails);



        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePick();
            }
        });

        timePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePick();
            }
        });



    }



    public void datePick() {

        final Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
            }
        },mDay, mMonth,mYear );

        datePickerDialog.show();
    }

    public void timePick(){
        final Calendar c= Calendar.getInstance();
        mHour= c.get(Calendar.HOUR_OF_DAY);

        mMinuiute=c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minuite) {
                time.setText(hourOfDay+":"+minuite);
            }
        },mHour,mMinuiute,false);
        timePickerDialog.show();
    }
}