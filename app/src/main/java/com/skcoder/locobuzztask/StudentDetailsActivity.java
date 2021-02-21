package com.skcoder.locobuzztask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentDetailsActivity extends AppCompatActivity {

    TextView uName, uRollno, uDepartment, uDeptCode, uDOB, uGender;
    String name, rollno, department, departmentCode, dob, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        this.setTitle("Student Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        uName = findViewById(R.id.uName);
        uRollno = findViewById(R.id.uRollno);
        uDepartment = findViewById(R.id.uDepartment);
        uDeptCode = findViewById(R.id.uDepartmentCode);
        uDOB = findViewById(R.id.uDOB);
        uGender = findViewById(R.id.uGender);

        name = getIntent().getStringExtra("name");
        rollno = getIntent().getStringExtra("rollno");
        department = getIntent().getStringExtra("department");
        departmentCode = getIntent().getStringExtra("departmentCodes");
        dob = getIntent().getStringExtra("DOB");
        gender = getIntent().getStringExtra("Gender");

        uName.setText(name);
        uRollno.setText(rollno);
        uDepartment.setText(department);
        uDeptCode.setText(departmentCode);
        uDOB.setText(dob);
        uGender.setText(gender);


    }
}