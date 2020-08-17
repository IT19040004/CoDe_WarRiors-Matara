package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplayChemistDetails extends AppCompatActivity {

    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_chemist_details);

        btnUpdate = (Button)findViewById(R.id.btnChemUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUpdate();
            }
        });
    }
    public void openUpdate(){
        Intent intent = new Intent(this, UpdateChemistDetails.class);
        startActivity(intent);
    }
}