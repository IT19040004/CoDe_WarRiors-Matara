package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.madgroup.R.id.listww;

public class LabChemistList extends AppCompatActivity {

    String item[]= new String[] {" 1 Mr.Sahan Rodrigo  Matara Durdans Hospital Laboratory"," 2 Ms.Ashani Chathurika Galle Asiri Hospital"," 3 Mr.Ananda Sampath  Kandy Good Health Laboratory"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_chemist_list);

        ListView listView=(ListView) findViewById(listww);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,item);
        listView.setAdapter(adapter);
    }
}
