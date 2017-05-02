package com.nathanmkaya.rahelper.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    public String regNo;
    public String hostel;
    public String wing;
    public String room;
    public List<Device> devices = new ArrayList<>();
    public boolean cleared = false;
    public String img;
    public String comment;

    public Student() {
    }

    public Student(String name, String regNo, String room, String img) {
        this.name = name;
        this.regNo = regNo;
        this.room = room;
        this.img = img;
    }

    public Student(String name, String regNo, String hostel, String wing, String room, String img) {
        this.name = name;
        this.regNo = regNo;
        this.hostel = hostel;
        this.wing = wing;
        this.room = room;
        this.img = img;
    }

    public Student(String name, String regNo, String room) {
        this.name = name;
        this.regNo = regNo;
        this.room = room;
    }

}
