package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
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
        loadStudents();
    }

    private void loadStudents() {
        SubjectDAO dao = new SubjectDAO(this);
        List<Subject> subjects = dao.listAll();
        dao.close();
        ArrayAdapter<Subject> listArrayAdapter = new ArrayAdapter<Subject>(this,
                android.R.layout.simple_list_item_1,
                subjects);
        ListView listView = findViewById(R.id.subject_list);
        listView.setAdapter(listArrayAdapter);
    }

    protected void onResume() {
        super.onResume();
        loadStudents();
    }



}
