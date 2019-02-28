package com.example.akhi.questionbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    //region Settings

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

    //endregion

    //region Students

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

    //endregion

    //region Examination

    static class tableExam
    {
        private static final String TABLE_NAME = "Examination";

        public static final String UID="_id";
        public static final String NAME= "Name";
        public static final String EXAMDATE= "ExamDate1"; //yyyy-MM-dd HH:mm:SS.SSS
        public static final String ANSWERTYPE= "AnswerTye";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ NAME+" VARCHAR(225), " + EXAMDATE + " VARCHAR(21), " + ANSWERTYPE + " INTEGER)";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    }

    public Cursor GetAllExam() {
        String[] columns = new String[] { tableExam.UID, tableExam.NAME};
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        Cursor cursor = dbb.query(tableExam.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public long insertExam(String ExamName, Date examDate, int answerSheetType)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(examDate);

        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tableExam.NAME, ExamName);
        contentValues.put(tableExam.EXAMDATE, strDate);
        contentValues.put(tableExam.ANSWERTYPE, answerSheetType);
        long id = dbb.insert(tableExam.TABLE_NAME, null , contentValues);
        return id;
    }

    public class ExamDetails
    {
        public long examId;
        public String examName;
        public Date examDate;
        public int answerSheetType;
    }

    public ExamDetails GetExamDetails(long examId)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {tableExam.UID, tableExam.NAME, tableExam.EXAMDATE, tableExam.ANSWERTYPE};
        String selection = tableExam.UID + " = ?";
        String[] selectionArgs = new String[]{ Long.toString(examId) };
        Cursor cursor = db.query(tableExam.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        ExamDetails examDetails = new ExamDetails();

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            examDetails.examId = cursor.getLong(cursor.getColumnIndex(tableExam.UID));
            examDetails.examName = cursor.getString(cursor.getColumnIndex(tableExam.NAME));
            String ExamDateStr = cursor.getString(cursor.getColumnIndex(tableExam.EXAMDATE));

            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            try {
                examDetails.examDate = format.parse(ExamDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            examDetails.answerSheetType = cursor.getInt(cursor.getColumnIndex(tableExam.ANSWERTYPE));
        }
        cursor.close();

        return examDetails;
    }

    //endregion

    //region Answer Key

    static class tableAnswerKey
    {
        private static final String TABLE_NAME = "AnswerKey";

        public static final String UID="_id";
        public static final String EXAMID= "ExamId";
        public static final String QUESTIONNO= "QuestionNo";
        public static final String  OPTION= "Option";

        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ EXAMID +" INTEGER, " + QUESTIONNO + " INTEGER, " + OPTION + " INTEGER)";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    }

    public class AnswerKey
    {
        public int QuestionNo;
        public int Option;

        public AnswerKey(int questionNo, int option)
        {
            this.QuestionNo = questionNo;
            this.Option = option;
        }
    }

    public ArrayList<AnswerKey> GetAnswerKeys(long ExamId)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {tableAnswerKey.QUESTIONNO, tableAnswerKey.OPTION};
        String selection = tableAnswerKey.EXAMID + " = ?";
        String[] selectionArgs = new String[]{Long.toString(ExamId)};
        Cursor cursor = db.query(tableAnswerKey.TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        ArrayList<AnswerKey> answerKeys = new ArrayList<AnswerKey>();

        if (cursor != null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    answerKeys.add(new AnswerKey(cursor.getInt(cursor.getColumnIndex(tableAnswerKey.QUESTIONNO)), cursor.getInt(cursor.getColumnIndex(tableAnswerKey.OPTION))));
                } while (cursor.moveToNext());
            }
        }

        cursor.close();
        return answerKeys;
    }

    public void InsertAnswerKey(long ExamId, ArrayList<AnswerKey> AnswerKeys)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();

        dbb.delete(tableAnswerKey.TABLE_NAME, tableAnswerKey.EXAMID + "=" + ExamId, null);

        for (AnswerKey aKey : AnswerKeys) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(tableAnswerKey.EXAMID, ExamId);
            contentValues.put(tableAnswerKey.QUESTIONNO, aKey.QuestionNo);
            contentValues.put(tableAnswerKey.OPTION, aKey.Option);
            dbb.insert(tableAnswerKey.TABLE_NAME, null , contentValues);
        }
    }

    //endregion

    //region DB Helper

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "Exam";    // Database Name
        private static final int DATABASE_Version = 7;    // Database Version
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
                db.execSQL(tableAnswerKey.CREATE_TABLE);
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
                db.execSQL(tableAnswerKey.DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }

    //endregion
}
