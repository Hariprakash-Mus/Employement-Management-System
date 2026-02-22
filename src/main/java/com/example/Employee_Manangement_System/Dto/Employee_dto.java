package com.example.Employee_Manangement_System.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Employee_dto {
    private long id;
    private String f_name;
    private String l_name;
    private String email;

    public Employee_dto( long id,String f_name, String l_name, String email) {
        this.id=id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
    }
//    public  Employee_dto(){}

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
