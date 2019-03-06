package com.example.barwal.attendancecompanion;


public class Subject {

    private String subjectName;
    private String subjectCode;



    public Subject(String subjectName, String subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
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
