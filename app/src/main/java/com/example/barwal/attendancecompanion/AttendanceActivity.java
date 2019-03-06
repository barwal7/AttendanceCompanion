package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class AttendanceActivity extends Activity {
    static List<Subject> subjects;
    static  Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        StudentDAO dao = new StudentDAO(this);
        subjects = dao.listAllSubjects();
        spinner = findViewById(R.id.subject_spinner);
        ArrayAdapter<Subject> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void beginAttendance(View view) {
        Intent intent = new Intent(AttendanceActivity.this,TakeAttendanceActivity.class);
        String subName = spinner.getSelectedItem().toString();
        intent.putExtra("SubjectName",subName);
        startActivity(intent);
        finish();

    }
}
