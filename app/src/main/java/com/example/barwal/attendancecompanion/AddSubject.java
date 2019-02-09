package com.example.barwal.attendancecompanion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubject extends AppCompatActivity {

    EditText subjectName;
    EditText subjectCode;
    EditText noOfStudents;
    Button addSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        subjectCode = findViewById(R.id.subjectCode);
        subjectName = findViewById(R.id.subjectName);
        noOfStudents = findViewById(R.id.noOfStudents);
        addSubject = findViewById(R.id.addSub);


        addSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(subjectName.getText().toString().isEmpty() || subjectName.getText().toString().isEmpty() || noOfStudents.getText().toString().isEmpty()))
                {
                    String subName = subjectName.getText().toString();
                    String subCode = subjectCode.getText().toString();
                    int totalStudents = Integer.parseInt(noOfStudents.getText().toString());
                    Subject sub = new Subject(subName,subCode,totalStudents);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_subject,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
