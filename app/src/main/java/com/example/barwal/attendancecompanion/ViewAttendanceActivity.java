package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ViewAttendanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);
        loadStudents();
    }
    private void loadStudents() {
        StudentDAO dao = new StudentDAO(this);
        List<Student> students = dao.listAllStudents();
        dao.close();
        ArrayAdapter<Student> listArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                students);
        ListView listView = findViewById(R.id.student_name);
        listView.setAdapter(listArrayAdapter);
    }
}
