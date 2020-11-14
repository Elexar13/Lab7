package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddAnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
    }

    public void onAddAnimalClick(View view) {
        EditText animalName = findViewById(R.id.addAnimalName);
        EditText animalClass = findViewById(R.id.addAnimalClass);
        AnimalGroups.addAnimal(
                new Animal(animalName.getText().toString(), animalClass.getText().toString(), false, false)
        );
        NavUtils.navigateUpFromSameTask(this);
    }
}