package com.example.akhi.questionbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long SaveSettings(String stName, String stValue)
    {
        deleteSettings(stName);
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tableSettings.STNAME, stName);
        contentValues.put(tableSettings.STVALUE, stValue);
        long id = dbb.insert(tableSettings.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getSettings(String StName) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {tableSettings.UID, tableSettings.STNAME, tableSettings.STVALUE};
        String selection = tableSettings.STNAME + " = ?";
        String[] selectionArgs = new String[]{StName};
        Cursor cursor = db.query(tableSettings.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        String StValue;
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            StValue = cursor.getString(cursor.getColumnIndex(tableSettings.STVALUE));
        } else {
            StValue = "";
        }
        cursor.close();
        return StValue;
    }

    public  int deleteSettings(String stName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={stName};

        int count =db.delete(tableSettings.TABLE_NAME ,tableSettings.STNAME+" = ?",whereArgs);
        return  count;
    }

/*    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
        return count;
    }*/

    static class tableSettings
    {
        private static final String TABLE_NAME = "Settings";   // Table Name

        private static final String UID="_id";     // Column I (Primary Key)
        private static final String STNAME = "Name";    //Column II
        private static final String STVALUE= "Value";    // Column III

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+STNAME+" VARCHAR(255) ,"+ STVALUE+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    }

    static class tableStudents
    {
        private static final String TABLE_NAME = "Students";

        private static final String UID="_id"; // Column I 
        private static final String REGNO = "RegNo"; //Column II
        private static final String NAME= "Name";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+REGNO+" VARCHAR(255) ,"+ NAME+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "Exam";    // Database Name
        private static final int DATABASE_Version = 2;    // Database Version
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(tableSettings.CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(tableSettings.DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
