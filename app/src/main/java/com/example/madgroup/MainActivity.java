package com.example.madgroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnLog,btnSignup;
    EditText email,password;
    DatabaseReference dbf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnLog = findViewById(R.id.btnLog);
        btnSignup = findViewById(R.id.btnSignup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        dbf = FirebaseDatabase.getInstance().getReference().child("Customer");

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbf.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot login:snapshot.getChildren()) {
                            String Email = login.child("email").getValue().toString();
                            String Password = login.child("password").getValue().toString();

                            if((email.getText().toString().equals(Email))&&(password.getText().toString().equals(Password))){
                                Toast.makeText(getApplicationContext(),"Login Complete",Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivity.this,PatientHome.class);
                                startActivity(intent);

                            }
                            else if((Email != email.getText().toString()) && (Password != password.getText().toString())){
                                Toast.makeText(getApplicationContext(),"Login Complete",Toast.LENGTH_SHORT).show();
                            }
                        }

                        email.setText("");
                        password.setText("");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Create_Customer_Account.class);
                startActivity(i);
            }
        });


    }
}
