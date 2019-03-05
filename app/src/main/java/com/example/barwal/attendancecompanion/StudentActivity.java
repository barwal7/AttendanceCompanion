package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class StudentActivity extends Activity {
    Button addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        addStudent = findViewById(R.id.addStudentButton);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentActivity.this,AddStudentActivity.class);
                startActivity(intent);
            }
        });
        loadStudents();
    }

    private void loadStudents() {
        StudentDAO dao = new StudentDAO(this);
        List<Student> students = dao.listAllStudents();
        dao.close();
        ArrayAdapter<Student> listArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                students);
        ListView listView = findViewById(R.id.student_list);
        listView.setAdapter(listArrayAdapter);
    }

    protected void onResume() {
        super.onResume();
        loadStudents();
    }
}
