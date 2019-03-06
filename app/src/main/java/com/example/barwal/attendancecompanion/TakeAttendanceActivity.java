package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TakeAttendanceActivity extends Activity {

    int num = 63001;
    ArrayList<CheckBox> checkBox = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);
        int noOfStudents = new StudentDAO(this).getStudentCount();
        addRadioButtons(noOfStudents);
    }

    public void addRadioButtons(int number) {
        for (int row = 0; row < 1; row++) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.VERTICAL);

            for (int i = 1; i <= number; i++) {
                CheckBox chkBox = new CheckBox(this);
                chkBox.setId(num);
                chkBox.setText("   "+num);
                chkBox.setChecked(true);
                checkBox.add(chkBox);
                num++;
                ll.addView(chkBox);
            }
            ((ViewGroup) findViewById(R.id.listOfStudents)).addView(ll);
        }
    }

    public void saveAttendance(View view) {
        StudentDAO dao= new StudentDAO(this);
        int noOfStudents = dao.getStudentCount();
        int [] i = new int[noOfStudents];
        int x = 0;
        for (CheckBox c : checkBox){
            if(c.isChecked()){
                i[x] = 1;
                x++;
            } else {
                i[x] = 0;
                x++;
            }
        }
        Student.totalLectures += 1;
        for(int z = 0; z < 20; z++){
            Student.attendance[z] = Student.attendance[z]+i[z];
        }
        Toast.makeText(this, "Attendance Saved Successfully.", Toast.LENGTH_LONG).show();
        finish();
    }
}
