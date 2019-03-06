package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ViewAttendanceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);
        loadStudents();
    }
    private void loadStudents() {
        int i = 0;
        StudentDAO dao = new StudentDAO(this);
        final List<Student> students = dao.listAllStudents();
        String[] studentName = new String[students.size()];
        dao.close();
        for(Student student : students){
            studentName[i] = student.getName()+"                            "+Student.attendance[i]+"/"+Student.totalLectures;
            i++;
        }
        ArrayAdapter<String> listArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                studentName);
        ListView listView = findViewById(R.id.student_name);
        listView.setAdapter(listArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewAttendanceActivity.this,IndividualDetailActivity.class);
                Student student = students.get(i);
                intent.putExtra("Name",student.getName());
                intent.putExtra("RollNo",student.getRollNo());
                intent.putExtra("Index",i);
                startActivity(intent);
                finish();
            }
        });
    }
}
