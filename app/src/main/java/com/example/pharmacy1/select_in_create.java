package com.example.pharmacy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select_in_create extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_in_create);
        button = (Button)findViewById(R.id.phrbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void openActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}