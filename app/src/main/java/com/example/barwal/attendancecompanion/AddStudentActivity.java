package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudentActivity extends Activity {

    EditText studentName;
    EditText rollNo;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentName = findViewById(R.id.studentName);
        rollNo = findViewById(R.id.roll_number);
        saveButton = findViewById(R.id.saveButton);
        final StudentDAO dao = new StudentDAO(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(studentName.getText().toString().isEmpty() || rollNo.getText().toString().isEmpty()))
                {
                    String name = studentName.getText().toString();
                    int roll = Integer.parseInt(rollNo.getText().toString());
                    dao.insertStudent(new Student(roll,name));
                    dao.close();
                    Toast.makeText(getApplicationContext(),name+" was Added!",Toast.LENGTH_LONG).show();
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
