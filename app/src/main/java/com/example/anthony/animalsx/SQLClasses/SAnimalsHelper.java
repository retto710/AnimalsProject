package com.example.anthony.animalsx.SQLClasses;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.anthony.animalsx.SQLClasses.SAnimals.AnimalEntry;
public class SAnimalsHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Animals.db";

    public SAnimalsHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SAnimalsHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SAnimalsHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + AnimalEntry.TABLE_NAME + " ("
                + AnimalEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + AnimalEntry.ID + " TEXT NOT NULL,"
                + AnimalEntry.NAME + " TEXT NOT NULL,"
                + AnimalEntry.PHOTOLINK + " TEXT NOT NULL,"
                + "UNIQUE (" + AnimalEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
