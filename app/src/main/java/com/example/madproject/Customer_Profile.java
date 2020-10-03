package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Customer_Profile extends AppCompatActivity {

    Button btnEnter, btnDelete, btnUpdate;
    EditText uappoinmentNumber,ucontactNo, uPName, uage, uappointmentData, uApTime, uappointmentNo, unicNo, uemail;
    TextView id;
    DatabaseReference doctorDbRef;

    DoctorAppointments dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__profile);

        id = findViewById(R.id.id);
        btnEnter = findViewById(R.id.btnEnter);
        btnDelete = findViewById(R.id.btnDalate);
        btnUpdate = findViewById(R.id.btnUpdate);
        uappoinmentNumber = findViewById(R.id.apEnter);
        ucontactNo = findViewById(R.id.conName);
        uPName = findViewById(R.id.paName);
        uage = findViewById(R.id.age);
        uappointmentData = findViewById(R.id.appDate);
        uApTime = findViewById(R.id.appTime);
        unicNo = findViewById(R.id.NIC);
        uemail = findViewById(R.id.eMail);

        dp = new DoctorAppointments();

        doctorDbRef = FirebaseDatabase.getInstance().getReference().child("Doctor_Appoinment");

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                database.getReference("Doctor_Appoinment").orderByChild("appointmentNo").equalTo(uappoinmentNumber.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            DoctorAppointments d = data.getValue(DoctorAppointments.class);
                            String ID;
                            ID = data.getKey().toString();
                            id.setText(ID);

                            uappoinmentNumber.setText(d.getAppointmentNo().toString());
                            ucontactNo.setText(d.getContactNo().toString());
                            uPName.setText(d.getPatientName().toString());
                            uage.setText(d.getAge().toString());
                            uappointmentData.setText(d.getAppointmentData().toString());
                            uApTime.setText(d.getAppointmentTime().toString());
                            unicNo.setText(d.getNicNo().toString());
                            uemail.setText(d.getEmail().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(uPName.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Name is Emplty", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(unicNo.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "NIC is Emplty", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(uappointmentData.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "AppointmentData is Emplty", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(uApTime.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "AppointmentTime is Emplty", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Update Success!", Toast.LENGTH_SHORT).show();
                        doctorDbRef = FirebaseDatabase.getInstance().getReference();
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("patientName").setValue(uPName.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("contactNo").setValue(ucontactNo.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("age").setValue(uage.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("appointmentData").setValue(uappointmentData.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("appointmentTime").setValue(uApTime.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("appointmentNo").setValue(uappoinmentNumber.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("nicNo").setValue(unicNo.getText().toString().trim());
                        doctorDbRef.child("Doctor_Appoinment").child(id.getText().toString()).child("email").setValue(uemail.getText().toString().trim());
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error!"+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctorDbRef = FirebaseDatabase.getInstance().getReference().child("Doctor_Appoinment").child(id.getText().toString());
                doctorDbRef.removeValue();
                uPName.setText("");
                ucontactNo.setText("");
                uage.setText("");
                uappointmentData.setText("");
                uApTime.setText("");
                unicNo.setText("");
                uemail.setText("");

                id.setText("");
                Toast.makeText(getApplicationContext(), "Succesfull!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}