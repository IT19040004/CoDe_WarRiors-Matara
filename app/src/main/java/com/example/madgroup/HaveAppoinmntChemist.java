package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class HaveAppoinmntChemist extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_appoinmnt_chemist);

        lv = (ListView)findViewById(R.id.progList);

        final String values[] = {"1  Heshan Walawage   2020-07-06   5.30 pm    abdc@gmail.com","2  Sanduni Kodikara   2020-07-20   3.30 pm   sanduni@gmail.com","3  Aruna Senanayake   2020-07-06  7.30 pm  aruna@gmail.com","4  Wruna Senanayake   2020-07-09  7.30 pm   waruna@gmail.com","5  Aruna Senanayake    2020-07-06  7.30 pm","2 Sanduni Kodikara   2020-07-20  3.30 pm  abdc@gmail.com","6 Nanduni Kodikara   2020-07-20  3.30 pm  hasindu@gmail.com","7 Aruna Senanayake   2020-07-06  7.30 pm  aruna@gmail.com","8 Aruna Senanayake   2020-07-06  7.30 pm  aruna@gmail.com","9  Heshan Walawage   2020-07-06   5.30 pm    abdc@gmail.com","10  Heshan Walawage   2020-07-06   5.30 pm    abdc@gmail.com","11  Heshan Walawage   2020-07-06   5.30 pm    abdc@gmail.com","2  Deshan Walawage   2020-07-06   5.30 pm    abdc@gmail.com","13  Heshan Walawage   2020-07-06   5.30 pm    abdc@gmail.com"};

       ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, Arrays.asList(values));

       lv.setAdapter(arrayAdapter);


       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Toast.makeText(HaveAppoinmntChemist.this,"You clicked : " + values[position],Toast.LENGTH_SHORT).show();
           }
       });

    }
}