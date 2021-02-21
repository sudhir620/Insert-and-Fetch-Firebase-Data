package com.skcoder.locobuzztask;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context context;
    ArrayList<StudentModel> list;

    public StudentAdapter(Context context, ArrayList<StudentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        StudentModel data = list.get(position);
        holder.name.setText(data.getName());
        holder.rollno.setText(data.getRollno());
        holder.dob.setText(data.getDOB());
        holder.department.setText(data.getDepartment());
        holder.departmentCode.setText(data.getDepartmentCode());
        holder.gender.setText(data.getGender());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, StudentDetailsActivity.class);
                i.putExtra("name", list.get(position).getName());
                i.putExtra("rollno", list.get(position).getRollno());
                i.putExtra("department", list.get(position).getDepartment());
                i.putExtra("departmentCodes", list.get(position).getDepartmentCode());
                i.putExtra("DOB", list.get(position).getDOB());
                i.putExtra("Gender", list.get(position).getGender());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView name, rollno, dob, department, departmentCode, gender;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            rollno = itemView.findViewById(R.id.rollno);
            dob = itemView.findViewById(R.id.dob);
            department = itemView.findViewById(R.id.dept);
            departmentCode = itemView.findViewById(R.id.deptCode);
            gender = itemView.findViewById(R.id.gender);
        }
    }
}
