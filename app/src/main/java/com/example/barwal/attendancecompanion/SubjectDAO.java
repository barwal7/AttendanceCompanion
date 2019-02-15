package com.example.barwal.attendancecompanion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends SQLiteOpenHelper {
    public SubjectDAO(@Nullable Context context) {
        super(context, "Subject", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Subject (id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT NOT NULL, CODE TEXT,NO_OF_LECTURES INTEGER DEFAULT '0');";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Subject subject) {
       SQLiteDatabase database =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",subject.getSubjectName());
        contentValues.put("CODE",subject.getSubjectCode());
        database.insert("Subject",null,contentValues);
    }

    public List<Subject> listAll() {
        List<Subject> subjects = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Subject", null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String code = cursor.getString(cursor.getColumnIndex("CODE"));
            int noOfLectures = cursor.getInt(cursor.getColumnIndex("NO_OF_LECTURES"));
            Subject sub = new Subject(name,code,noOfLectures);
            subjects.add(sub);
        }
        return subjects;
    }
}
