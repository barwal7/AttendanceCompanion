package com.example.barwal.attendancecompanion;

import java.util.ArrayList;

public class Subject {

    private String subjectName;
    private String subjectCode;
    private int noOfLectures = 0;



    public Subject(String subjectName, String subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    public Subject(String subjectName, String subjectCode, int noOfLectures) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.noOfLectures = noOfLectures;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }


    public String toString() {
        return this.subjectName+" : "+this.subjectCode;
    }
}
