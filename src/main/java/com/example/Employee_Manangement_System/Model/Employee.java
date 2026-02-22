package com.example.Employee_Manangement_System.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "f_name")
    private String f_name;
    @Column(name="l_name")
    private String l_name;
    @Column(name = "email",nullable = true)
    private String email;
    public Employee(String f_name,String l_name,String email){

        this.f_name=f_name;
        this.l_name=l_name;
        this.email=email;
    }
    public Employee(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
