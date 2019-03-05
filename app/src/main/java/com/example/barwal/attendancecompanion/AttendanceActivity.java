package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class AttendanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        StudentDAO dao = new StudentDAO(this);
        List<Subject> subjects = dao.listAllSubjects();
        Spinner spinner = findViewById(R.id.subject_spinner);
        ArrayAdapter<Subject> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void beginAttendance(View view) {
        Intent intent = new Intent(AttendanceActivity.this,TakeAttendanceActivity.class);
        startActivity(intent);

    }
}
