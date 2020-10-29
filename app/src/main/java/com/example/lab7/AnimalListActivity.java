package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AnimalListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String animal = adapterView.getItemAtPosition(i).toString();
                Intent intent = new Intent(AnimalListActivity.this, AnimalGroupActivity.class);
                intent.putExtra(AnimalGroupActivity.ANIMAL_NAME, animal);
                startActivity(intent);
            }
        };
        ListView listView = findViewById(R.id.animals_list);
        ArrayAdapter<Animal> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, AnimalGroups.getAnimals());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);
    }
}