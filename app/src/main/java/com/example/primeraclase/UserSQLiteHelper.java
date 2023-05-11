package com.example.primeraclase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserSQLiteHelper extends SQLiteOpenHelper {

    String createSQL = "CREATE TABLE user (id INTEGER, name TEXT)";
    String dropSQL = "DROP TABLE IF EXISTS user";

    private static final String DATABASE_ALTER_v3 = "ALTER TABLE user ADD COLUMN country TEXT";


    public static final String DATABASE_NAME = "Users.db";
    public static final int DATABASE_VERSION = 3;

    public UserSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Execute the SQL sentence for creating the table
        db.execSQL(createSQL);
        insertDefaultData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropSQL);
        onCreate(db);

        if (oldVersion < 3) {
            db.execSQL(DATABASE_ALTER_v3);
        }

    }

    public void insertDefaultData(SQLiteDatabase db){
        //We will insert 5 new rows
        for (int i = 1; i <= 5; i++)
        {
            //Insert the record in the database
            insertUser(db, i, "User" + i);
        }
    }

    public void insertUser(SQLiteDatabase db, int id, String name){
        ContentValues newRecord = new ContentValues();
        newRecord.put("id", id);
        newRecord.put("name", name);
        //Insert the record in the database
        db.insert("user", null, newRecord);
    }

    public void updateUserById(SQLiteDatabase db, int id, String newName) {
        //We have to put the new values
        ContentValues values = new ContentValues();
        values.put("name", newName);
        //Update the record in the database
        String[] args = new String[] {Integer.toString(id)};
        //Update the record in the database
        db.update("user", values, "id=?", args);
    }

    public void deleteUserById(SQLiteDatabase db, int id){
        String[] args = new String[] {Integer.toString(id)};
        db.delete("user", "id=?", args);
    }

    public Cursor getUser(SQLiteDatabase db, String name){
        String[] fields = new String[] {"id", "name"};
        String[] args = new String[] {name};
        Cursor c = db.query("user", fields, "name=?",
                args, null, null, null);
        return c;
    }

    public Cursor getAllUsers(SQLiteDatabase db){
        String[] fields = new String[] {"id", "name"};
        Cursor c = db.query("user", fields, null,
                null, null, null, null);
        return c;
    }

}
