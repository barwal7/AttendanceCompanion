package com.example.barwal.attendancecompanion;

public class Subject {

    private String subjectName;
    private String subjectCode;
    private int noOfStudents;

    public Subject(String subjectName, String subjectCode, int noOfStudents) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.noOfStudents = noOfStudents;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }
}
