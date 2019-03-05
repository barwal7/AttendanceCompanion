package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class TakeAttendanceActivity extends Activity {

    int num = 63001;

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
                chkBox.setId(View.generateViewId());
                chkBox.setText("   "+num);
                chkBox.setChecked(true);
                num++;
                ll.addView(chkBox);
            }
            ((ViewGroup) findViewById(R.id.listOfStudents)).addView(ll);
        }
    }
}
