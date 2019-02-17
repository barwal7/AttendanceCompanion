package com.example.barwal.attendancecompanion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void startStudent(View view) {
        Intent intent = new Intent(HomeActivity.this,StudentActivity.class);
        startActivity(intent);
    }
    public void startSubject(View view) {
        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
