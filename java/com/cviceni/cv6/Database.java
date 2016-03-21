package com.cviceni.cv6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    private static String dbName = "UHK";
    private static int dbVersion = 1;
    // all names of tables etc write as static here

    public Database(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE friends " +
                "(id INTEGER PRIMARY KEY NOT NULL, " +
                "name TEXT, " +
                "email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO load data save it to new table etc..
        db.execSQL("DROP TABLE friends");
        onCreate(db);
    }

    public void saveFriend(String name, String email) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);

        getWritableDatabase().insert("friends", null, cv);
    }

    public ArrayList<String> getAllFriends() {
        ArrayList<String> friends = new ArrayList<String>();

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM friends", null);
        if(cursor.moveToFirst()) {
            do {
                String friend = cursor.getInt(0) + ". " + cursor.getString(1);
                friends.add(friend);
            } while( cursor.moveToNext() );
        }
        cursor.close();

        return friends;
    }
}
