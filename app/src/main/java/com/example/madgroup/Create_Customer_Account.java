package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_Customer_Account extends AppCompatActivity {

    Button subbtn;
    EditText name,email,password,phone;
    DatabaseReference dbf;
    CusAcc cus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__customer__account);

        subbtn = findViewById(R.id.subbtn);
        name = findViewById(R.id.name);
        email= findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);

        cus = new CusAcc();
        dbf = FirebaseDatabase.getInstance().getReference().child("Customer");

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Phone = phone.getText().toString();

                try {
                    if (TextUtils.isEmpty(Name)) {

                    } else if (TextUtils.isEmpty(Email)) {

                    } else if (TextUtils.isEmpty(Password)) {

                    } else if (TextUtils.isEmpty(Phone)) {

                    } else if ((Name != null) && (Email != null) && (Password != null) && (Phone != null)) {
                        cus.setName(Name);
                        cus.setEmail(Email);
                        cus.setPassword(Password);
                        cus.setPhone(Phone);

                        System.out.println("check1");

                        dbf.push().setValue(cus);

                        System.out.println("check2");
                        Intent intent = new Intent(Create_Customer_Account.this, MainActivity.class);
                        System.out.println("check3");
                        startActivity(intent);
                        System.out.println("check4");

                        name.setText("");
                        email.setText("");
                        password.setText("");
                        phone.setText("");
                    }
                } catch (Exception e) {


                }
            }
        });


    }
}





