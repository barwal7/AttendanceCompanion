package com.example.barwal.attendancecompanion;

public class Student {

    private int rollNo;
    private int year;
    private String name;


    public Student(int rollNo, String name, int year) {
        this.rollNo = rollNo;
        this.year = year;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
