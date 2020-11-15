package com.example.lab7;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AnimalsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "animals";
    private static final int DB_VERSION = 1;

    public AnimalsDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
            }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlText = "CREATE TABLE animal (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT (100) NOT NULL, " +
                "class TEXT (50), " +
                "is_predator BOOLEAN, " +
                "is_flying BOOLEAN" +
                ")";
        db.execSQL(sqlText);
        updateShema(db, 0);
        populateDB(db);
    }


    private void populateDB(SQLiteDatabase db) {
        populateAnimals(db);
        populateAnimalGroups(db);
    }

    private void populateAnimals(SQLiteDatabase db){
        for (Animal animal : AnimalGroups.getAnimals()){
            insertRowToAnimal(db, animal);
        }
    }

    private void populateAnimalGroups(SQLiteDatabase db){
        for (Animal animal : AnimalGroups.getAnimals()){
            insertRowToAnimalClass(db, animal);
        }
    }


    private void insertRowToAnimal(SQLiteDatabase db, Animal animal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", animal.getName());
        contentValues.put("class", animal.getGroup());
        contentValues.put("is_predator", animal.isPredator());
        contentValues.put("is_flying", animal.isFlying());

        db.insert("animal", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        updateShema(db, oldV);
    }

    private void insertRowToAnimalClass(SQLiteDatabase db, Animal animal){
        db.execSQL("insert into animal_class (name, animal_id) " +
                "select '"+ animal.getGroup() +"', id " +
                "from animal " +
                "where name='"+ animal.getName() + "' ");
    }

    private void updateShema(SQLiteDatabase db, int oldV) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        if (oldV < 2){
            System.out.println("BBBBBBBBBBBBBBBBBBBBBBB");
            db.execSQL("CREATE TABLE animal_class (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT (100) NOT NULL, " +
                    "animal_id INTEGER REFERENCES animals (id) ON DELETE RESTRICT " +
                    "ON UPDATE RESTRICT );");
            populateAnimalGroups(db);
        }
    }
}
