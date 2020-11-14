package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

public class AnimalListActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.animals_menu, menu);

        String text = "";
        for (Animal animal : AnimalGroups.getAnimals()){
            text += animal.getName() + "\n";
        }

        MenuItem menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_animal:
                startActivity(new Intent(this, AddAnimalActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView listView = findViewById(R.id.animals_list);
        ArrayAdapter<Animal> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, AnimalGroups.getAnimals());
        listView.setAdapter(adapter);
    }

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

    public void onAnAddClick(View view) {
        startActivity(new Intent(this, AddAnimalActivity.class));
    }
}