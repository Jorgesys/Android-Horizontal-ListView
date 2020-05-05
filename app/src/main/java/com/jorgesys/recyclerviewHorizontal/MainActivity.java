package com.jorgesys.recyclerviewHorizontal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initArrayPersons();

        RecyclerView recyclerViewH = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewH.setAdapter(new MyRecyclerViewAdapter(persons, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(MainActivity.this, persons.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        //Horizontal orientation.
        recyclerViewH.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void initArrayPersons() {
        persons = new ArrayList<Person>();
        //Get values from strings.xml
        String[] names = getResources().getStringArray(R.array.names);
        int[] ages = getResources().getIntArray(R.array.ages);
        String[] urlImages = getResources().getStringArray(R.array.images);
        //Store values in ArrayList persons.
        for (int i = 0; i < names.length; i++) {
            persons.add(new Person(names[i], ages[i], urlImages[i]));
        }
    }

}
