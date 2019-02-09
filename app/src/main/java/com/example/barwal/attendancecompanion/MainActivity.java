package com.example.barwal.attendancecompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addSubject;
    public ArrayList<Subject> mSubject;

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
    }
    public void newSubject(Subject sub) {
        mSubject.add(sub);
    }


}
