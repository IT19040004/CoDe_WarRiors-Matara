package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class doctor__appointment extends AppCompatActivity {

    Button submitAppointment;
    EditText patientName,contactNo,age,appointmentData,appointmentTime,appointmentNo,nicNo,email;
    DatabaseReference doctorDbRef;
    DoctorAppointments da;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__appointment);

        submitAppointment=findViewById(R.id.btnUpdate);
        patientName=findViewById(R.id.patientName);
        contactNo=findViewById(R.id.conName);
        age=findViewById(R.id.age);
        appointmentData=findViewById(R.id.appDate);
        appointmentTime=findViewById(R.id.appTime);
        appointmentNo=findViewById(R.id.uappointmentNo);
        nicNo=findViewById(R.id.NIC);
        email=findViewById(R.id.eMail);

        da = new DoctorAppointments();
        doctorDbRef = FirebaseDatabase.getInstance().getReference().child("Doctor_Appoinment");

        submitAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patientNameTXT = patientName.getText().toString();
                String contactNoTXT = contactNo.getText().toString();
                String ageTXT = age.getText().toString();
                String appointmentDataTXT = appointmentData.getText().toString();
                String appointmentTimeTXT = appointmentTime.getText().toString();
                String appointmentNoTXT = appointmentNo.getText().toString();
                String nicNoTXT = nicNo.getText().toString();
                String emailTXT = email.getText().toString();

                da.setPatientName(patientNameTXT);
                da.setContactNo(contactNoTXT);
                da.setAge(ageTXT);
                da.setAppointmentData(appointmentDataTXT);
                da.setAppointmentTime(appointmentTimeTXT);
                da.setAppointmentNo(appointmentNoTXT);
                da.setNicNo(nicNoTXT);
                da.setEmail(emailTXT);

                doctorDbRef.push().setValue(da);

                patientName.setText("");
                contactNo.setText("");
                age.setText("");
                appointmentData.setText("");
                appointmentTime.setText("");
                appointmentNo.setText("");
                nicNo.setText("");
                email.setText("");
            }
        });
    }

}