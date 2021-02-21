package com.skcoder.locobuzztask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class AddStudent extends AppCompatActivity {

    DatabaseReference reference;

    EditText etName, etRollno, etDept, etDeptCode, etDOB, etGender;
    Button submitBtn;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Add Student");

        reference = FirebaseDatabase.getInstance().getReference().child("Students");

        etName = findViewById(R.id.etName);
        etRollno = findViewById(R.id.etRollno);
        etDept = findViewById(R.id.etDept);
        etDeptCode = findViewById(R.id.etDeptCode);
        etDOB = findViewById(R.id.etDOB);
        etGender = findViewById(R.id.etGender);
        submitBtn = findViewById(R.id.submitBtn);
        pd = new ProgressDialog(this);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validation();
            }
        });
    }

    private void Validation() {
        String name,rollno,dept,deptcode,dob,gender;
        name = etName.getText().toString().trim();
        rollno = etRollno.getText().toString().trim();
        dept = etDept.getText().toString().trim();
        deptcode = etDeptCode.getText().toString().trim();
        dob = etDOB.getText().toString().trim();
        gender = etGender.getText().toString().trim();

        if (TextUtils.isEmpty(name)){
            etName.setError("Name is Required!");
            etName.requestFocus();
        }else if (TextUtils.isEmpty(rollno)){
            etRollno.setError("Rollno is Required!");
            etRollno.requestFocus();
        }else if (TextUtils.isEmpty(dept)){
            etDept.setError("Deptment is Required!");
            etDept.requestFocus();
        }else if (TextUtils.isEmpty(deptcode)){
            etDeptCode.setError("Deptment code is Required!");
            etDeptCode.requestFocus();
        }else if (TextUtils.isEmpty(dob)){
            etDOB.setError("DOB is Required!");
            etDOB.requestFocus();
        }else if (TextUtils.isEmpty(gender)){
            etGender.setError("Name is Required!");
            etGender.requestFocus();
        }else {
            insertData();
        }
    }

    private void insertData() {
        pd.setMessage("Inserting...");
        pd.show();
        String uniqueKey = reference.push().getKey();

        HashMap hashMap = new HashMap();
        hashMap.put("name", etName.getText().toString());
        hashMap.put("rollno", etRollno.getText().toString());
        hashMap.put("department", etDept.getText().toString());
        hashMap.put("departmentCode", etDeptCode.getText().toString());
        hashMap.put("DOB", etDOB.getText().toString());
        hashMap.put("gender", etGender.getText().toString());

        reference.child(uniqueKey).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                Toast.makeText(AddStudent.this, "Student Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(AddStudent.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}