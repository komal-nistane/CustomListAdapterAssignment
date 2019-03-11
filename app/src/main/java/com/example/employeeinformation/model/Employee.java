package com.example.employeeinformation.model;

import com.example.employeeinformation.R;

import java.util.ArrayList;

public class Employee {

    int image;
    String name;
    String profession;

    int images[] = {R.drawable.person1, R.drawable.person2,
            R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6,
            R.drawable.person7, R.drawable.person8, R.drawable.person9, R.drawable.person10,
    };

    String empName[] = {"Komal", "Swati", "Rakesh", "Ragini", "Amit",
            "Akash", "Arjun", "Ashwini", "Anita", "Yamini"};

    String empDesignation[] = {"Developer", "Developer", "Manager", "Developer", "Tester",
            "Developer", "Developer", "Manager", "Developer", "Tester"};


    public ArrayList<Employee> getEmployeeList() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            employees.add(new Employee(images[i], empName[i], empDesignation[i]));
        }
        return  employees ;
    }

    public Employee() {
    }

    public Employee(int image, String name, String profession) {
        this.image = image;
        this.name = name;
        this.profession = profession;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

