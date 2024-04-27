package com.example.demo.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class Person
{
    @Id
    int empid;
    String empname;
    int age;
    String role;
    String dept;
    String email;
    String contact;
    public Person(){
        
    }
    public Person(int empid, String empname, int age, String role, String dept, String email, String contact) {
        this.empid = empid;
        this.empname = empname;
        this.age = age;
        this.role = role;
        this.dept = dept;
        this.email = email;
        this.contact = contact;
    }
    public int getEmpid() {
        return empid;
    }
    public String getEmpname() {
        return empname;
    }
    public int getAge() {
        return age;
    }
    public String getRole() {
        return role;
    }
    public String getDept() {
        return dept;
    }
    public String getEmail() {
        return email;
    }
    public String getContact() {
        return contact;
    }
}

