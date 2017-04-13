package com.nathanmkaya.rahelper.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    public String name;
    public String regNo;
    public String room;
    public ArrayList<Device> devices;
    public boolean cleared = false;
    public String img;

    public Student() {
    }

    public Student(String name, String regNo, String room, String img) {
        this.name = name;
        this.regNo = regNo;
        this.room = room;
        this.img = img;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("regNo", regNo);
        result.put("room", room);
        result.put("devices", devices);
        result.put("cleared", cleared);
        result.put("img", img);

        return result;
    }

}
