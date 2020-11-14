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
        String sqlText = "CREATE TABLE animals (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT (10) NOT NULL, " +
                "class TEXT (50), " +
                "is_predator BOOLEAN, " +
                "is_flying BOOLEAN" +
                ")";
        db.execSQL(sqlText);
        populateDB(db);
    }

    private void populateDB(SQLiteDatabase db) {
        for (Animal animal : AnimalGroups.getAnimals()){
            insertRow(db, animal);
        }
    }

    private void insertRow(SQLiteDatabase db, Animal animal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", animal.getName());
        contentValues.put("class", animal.getGroup());
        contentValues.put("is_predator", animal.isPredator());
        contentValues.put("is_flying", animal.isFlying());

        db.insert("Animals", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }
}
