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
    Button addSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        subjectCode = findViewById(R.id.subjectCode);
        subjectName = findViewById(R.id.subjectName);
        addSubject = findViewById(R.id.addSub);
        final SubjectDAO dao = new SubjectDAO(this);


        addSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(subjectName.getText().toString().isEmpty() || subjectName.getText().toString().isEmpty()))
                {
                    String subName = subjectName.getText().toString();
                    String subCode = subjectCode.getText().toString();
                    dao.insert(new Subject(subName,subCode));
                    dao.close();
                    Toast.makeText(getApplicationContext(),"Subject Added!",Toast.LENGTH_LONG).show();
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
