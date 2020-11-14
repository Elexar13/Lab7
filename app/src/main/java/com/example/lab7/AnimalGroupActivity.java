package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalGroupActivity extends AppCompatActivity {

    public static final String ANIMAL_NAME = "animal name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_group2);

        Intent intent = getIntent();
        String animalName = intent.getStringExtra(ANIMAL_NAME);

        Animal animal = AnimalGroups.getAnimal(animalName);

        EditText txtAnimalName = findViewById(R.id.animalNameEdit);
        txtAnimalName.setText(animal.getName());

        EditText txtClassName = findViewById(R.id.animalClassEdit);
        txtClassName.setText(animal.getGroup());

        TextView txtImgName = findViewById(R.id.animalNameImageTxt);
        txtImgName.setText(animal.getName());

        TextView txtImgClass = findViewById(R.id.animalClassImageTxt);
        txtImgClass.setText(animal.getGroup());

        ((CheckBox) findViewById(R.id.is_flying)).setChecked(animal.isFlying());
        ((CheckBox) findViewById(R.id.is_not_flying)).setChecked(!animal.isFlying());

        ((RadioButton) findViewById(R.id.is_predator)).setChecked(animal.isPredator());
        ((RadioButton) findViewById(R.id.is_not_predator)).setChecked(!animal.isPredator());
    }

    public void onOkBtnClick(View view) {
        StringBuilder text = new StringBuilder();
        text.append("Тварина: " + ((TextView)findViewById(R.id.animalNameEdit)).getText() + "\n");
        text.append("Клас: " + ((TextView)findViewById(R.id.animalClassEdit)).getText() + "\n");

        if (((RadioButton) findViewById(R.id.is_predator)).isChecked()){
            text.append("Хижак \n");
        }else{
            text.append("Не хижак \n");
        }

        if (((CheckBox) findViewById(R.id.is_flying)).isChecked()){
            text.append("Літає \n");
        }else{
            text.append("Не літає \n");
        }

        Toast.makeText(this, text.toString(), Toast.LENGTH_LONG).show();
    }
}