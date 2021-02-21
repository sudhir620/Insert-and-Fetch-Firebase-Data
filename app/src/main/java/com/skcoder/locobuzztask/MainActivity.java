package com.skcoder.locobuzztask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;

    RecyclerView studentRecycle;
    DatabaseReference reference;
    private ArrayList<StudentModel> list;

    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);

        studentRecycle = findViewById(R.id.studentRecycle);
        reference = FirebaseDatabase.getInstance().getReference().child("Students");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddStudent.class));
            }
        });

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    StudentModel data = dataSnapshot.getValue(StudentModel.class);
                    list.add(data);
                }
                Collections.reverse(list);
                adapter = new StudentAdapter(getApplicationContext(),list);
                studentRecycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                studentRecycle.setHasFixedSize(true);
                studentRecycle.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}