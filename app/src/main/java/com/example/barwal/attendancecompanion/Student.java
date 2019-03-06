package com.example.barwal.attendancecompanion;

public class Student {

    private int rollNo;
    private String name;
    static int [] attendance = {24,23,25,21,20,18,12,20,19,22,23,24,21,20,17,10,21,23,25,25};
    static int totalLectures = 25;


    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return this.rollNo+" : "+this.getName();
    }
}
