package com.example.barwal.attendancecompanion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends SQLiteOpenHelper {
    public StudentDAO(@Nullable Context context) {
        super(context, "Student", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Students (rollNo INTEGER PRIMARY KEY, NAME TEXT NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Student student) {
        SQLiteDatabase database =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rollNo",student.getRollNo());
        contentValues.put("NAME",student.getName());
        database.insert("Students",null,contentValues);
    }
    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Students", null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            int rollNo = cursor.getInt(cursor.getColumnIndex("rollNo"));
            Student student = new Student(rollNo,name);
            students.add(student);
        }
        return students;
    }
}
