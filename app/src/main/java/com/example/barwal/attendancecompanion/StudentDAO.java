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
        sql = "CREATE TABLE Subject (id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT NOT NULL, CODE TEXT,NO_OF_LECTURES INTEGER DEFAULT '0');";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertSubject(Subject subject) {
        SQLiteDatabase database =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",subject.getSubjectName());
        contentValues.put("CODE",subject.getSubjectCode());
        database.insert("Subject",null,contentValues);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase database =  getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rollNo",student.getRollNo());
        contentValues.put("NAME",student.getName());
        database.insert("Students",null,contentValues);
    }
    public List<Student> listAllStudents() {
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
    public List<Subject> listAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Subject", null);
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String code = cursor.getString(cursor.getColumnIndex("CODE"));
            Subject sub = new Subject(name,code);
            subjects.add(sub);
        }
        return subjects;
    }
    public void addSubject(String subName){
        String sql = "ALTER TABLE Students ADD COLUMN "+subName+" INTEGER DEFAULT '0'";
        SQLiteDatabase database =  getWritableDatabase();
        database.execSQL(sql);
    }
    public int getStudentCount() {
        String countQuery = "SELECT  * FROM Students";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void updateAttendance(int[] i) {
    }
}
