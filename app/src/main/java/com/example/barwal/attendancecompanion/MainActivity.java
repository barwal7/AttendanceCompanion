package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;


public class MainActivity extends Activity {

    Button addSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addSubject = findViewById(R.id.addSubjectButton);
        addSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddSubject.class);
                startActivity(intent);
            }
        });
        loadSubjects();
    }

    private void loadSubjects() {
        StudentDAO dao = new StudentDAO(this);
        List<Subject> subjects = dao.listAllSubjects();
        dao.close();
        ArrayAdapter<Subject> listArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                subjects);
        ListView listView = findViewById(R.id.subject_list);
        listView.setAdapter(listArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ViewAttendanceActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        loadSubjects();
    }
}
