package com.example.madgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import static com.example.madgroup.R.id.listww;

public class LabChemistList extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    Button addNew,previosLabApp;

    String item[]= new String[] {" 1 Sahan Karunathilake Galle... Durdans Hospital Laboratory"," 2 Ajith Nanayakkara Matara... Nawaloka Hospital Laboratory",
            " 3 Daham Karunathilake Galle... Hemas Hospital Laboratory"," 4 Sahan Nagahawatta Galle... Nawaloka Hospital Laboratory",
            "5 Ashani  Chathurika Matara... Asiri Hospital Laboratory"," 6 Ananda Sampath  Kottawa... Good Health Laboratory",
            " 7 Krishantha Senevirathne Kandy...  Asiri Hospital Laboratory"," 8 Yethmi Udugampala Colombo...  Asiri Hospital Laboratory",
            " 9 Ananda Sampath  Kottawa... Good Health Laboratory"," 10 Nimal Katipearachi  Colombo... Hemas Hospital Laboratory"};

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_chemist_list);

        listView=(ListView) findViewById(listww);
        addNew = (Button)findViewById(R.id.btnGo);
        previosLabApp = (Button)findViewById(R.id.btnPreLabApp);
        searchView=(SearchView)findViewById(R.id.searchView);



        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,item);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddAppointment();
            }
        });


    }

    public void openAddAppointment(){
        Intent intent = new Intent(this, LabChemAppointment.class);
        startActivity(intent);
    }


}
