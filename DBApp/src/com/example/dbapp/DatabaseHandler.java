package com.example.dbapp;

import java.util.LinkedList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{
	 
	// Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "AppDB";

    public DatabaseHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create string table
        String CREATE_STRING_TABLE = "CREATE TABLE strings ( " +
                "id STRING PRIMARY KEY)";
 
        // create strings table
        db.execSQL(CREATE_STRING_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older strings table if existed
        db.execSQL("DROP TABLE IF EXISTS strings");
 
        // create fresh strings table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------
    
    /**
     * CRUD operations (create "add", read "get", update, delete) string + get all strings + delete all strings
     */
 
    // Strings table name
    private static final String TABLE_STRINGS = "strings";
 
    // Strings Table Columns names
    private static final String KEY_ID = "id";
 
    private static final String[] COLUMNS = {KEY_ID};
 
    public void addString(String string){
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
          values.put(KEY_ID, string);
 
        // 3. insert
        db.insert(TABLE_STRINGS, // table
                null,
                values);
 
        // 4. close
        db.close();
    }
 
    public String getString(String id){
 
        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
 
        // 2. build query
        Cursor cursor =
                db.query(TABLE_STRINGS, // a. table
                COLUMNS, 				// b. column names
                " id = ?", 				// c. selections
                new String[] { id }, 	// d. selections args
                null, 					// e. group by
                null, 					// f. having
                null, 					// g. order by
                null); 					// h. limit
 
        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        String string = cursor.getString(0);
 
        // 5. return string
        return string;
    }
 
    // Get All Strings
    public List<String> getAllStrings() {
        List<String> strings = new LinkedList<String>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_STRINGS;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build string and add it to list
        String string = null;
        if (cursor.moveToFirst()) {
            do {
                string = cursor.getString(0);
 
                // Add string to strings
                strings.add(string);
            } while (cursor.moveToNext());
        }
 
 
        // return strings
        return strings;
    }
 
     // Updating single string
    public int updateString(String string) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_ID, string);
 
        // 3. updating row
        int i = db.update(TABLE_STRINGS, 	//table
                values, 					// column/value
                KEY_ID+" = ?", 				// selections
                new String[] { string }); 	//selection args
 
        // 4. close
        db.close();
 
        return i;
 
    }
 
    // Deleting single string
    public void deleteString(String string) {
 
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
        // 2. delete
        db.delete(TABLE_STRINGS,
                KEY_ID+" = ?",
                new String[] { string });
 
        // 3. close
        db.close();
 
 
    }
}