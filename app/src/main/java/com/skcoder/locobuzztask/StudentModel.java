package com.skcoder.locobuzztask;

public class StudentModel {
    String name,rollno,DOB,department, departmentCode,gender;

    public StudentModel() {
    }

    public StudentModel(String name, String rollno, String DOB, String department, String departmentCode, String gender) {
        this.name = name;
        this.rollno = rollno;
        this.DOB = DOB;
        this.department = department;
        this.departmentCode = departmentCode;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
