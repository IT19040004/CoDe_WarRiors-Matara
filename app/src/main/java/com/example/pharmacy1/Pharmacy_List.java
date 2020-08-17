package com.example.pharmacy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;

public class Pharmacy_List extends AppCompatActivity {

    ListView lv;

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy__list);

        lv =(ListView) findViewById(R.id.listviewnn);
        String values[] ={"P001 - Supipi - Supipi,Matara", "P002 - Asiri - Asiri,Nupe,Matara","P003 - Samahan - Samahan,Maradana", "P004 - Sithara - Sithara,Galle"};


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, Arrays.asList(values));

        lv.setAdapter(arrayAdapter);








        button = (Button)findViewById(R.id.newodbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this,place_pharmacy_order.class);
        startActivity(intent);
    }
}