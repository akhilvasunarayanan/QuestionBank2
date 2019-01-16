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

    static class tableStudents
    {
        private static final String TABLE_NAME = "Students";

        public static final String UID="_id"; // Column I
        public static final String REGNO = "RegNo"; //Column II
        public static final String NAME= "Name";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+REGNO+" VARCHAR(255) ,"+ NAME+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    }

    public long insertStudent(String RegNo, String Name) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tableStudents.REGNO, RegNo);
        contentValues.put(tableStudents.NAME, Name);
        long id = dbb.insert(tableStudents.TABLE_NAME, null , contentValues);
        return id;
    }

    public int updateStudent(long _id, String RegNo, String Name) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tableStudents.REGNO, RegNo);
        contentValues.put(tableStudents.NAME, Name);
        int i = dbb.update(tableStudents.TABLE_NAME, contentValues, tableStudents.UID + " = " + _id, null);
        return i;
    }

    public void deleteStudent(long _id) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        dbb.delete(tableStudents.TABLE_NAME, tableStudents.UID + "=" + _id, null);
    }

    public Cursor GetAllStudents() {
        String[] columns = new String[] { tableStudents.UID, tableStudents.REGNO, tableStudents.NAME };
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        Cursor cursor = dbb.query(tableStudents.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    static class tableExam
    {
        private static final String TABLE_NAME = "Examination";

        public static final String UID="_id";
        public static final String NAME= "Name";
        public static final String EXAMDATE= "ExamDate";
        public static final String ANSWERTYPE= "AnswerTye";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ NAME+" VARCHAR(225), " + EXAMDATE + " VARCHAR(12), " + ANSWERTYPE + " INTEGER)";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    }

    public Cursor GetAllExam() {
        String[] columns = new String[] { tableExam.UID, tableExam.NAME, tableExam.EXAMDATE };
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        Cursor cursor = dbb.query(tableStudents.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "Exam";    // Database Name
        private static final int DATABASE_Version = 3;    // Database Version
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(tableSettings.CREATE_TABLE);
                db.execSQL(tableStudents.CREATE_TABLE);
                db.execSQL(tableExam.CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(tableSettings.DROP_TABLE);
                db.execSQL(tableStudents.DROP_TABLE);
                db.execSQL(tableExam.DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
