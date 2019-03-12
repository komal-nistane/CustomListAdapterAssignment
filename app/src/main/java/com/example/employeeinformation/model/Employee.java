package com.example.employeeinformation.model;

import com.example.employeeinformation.R;

import java.util.ArrayList;

public class Employee {

    int image;
    String name;
    String profession;

    int images[] = {R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10,
    };

    String empName[] = {"Rakesh","Komal" ,"Swati","Ragini", "Amit",
            "Akash", "Arjun", "Ramesh","Ashwini", "Anita"};

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

