package com.nathanmkaya.rahelper.model;

import java.util.Date;

public class Maintenance {
    public String hostel;
    public String wing;
    public String issue;
    public long datePosted = System.currentTimeMillis();
    public Date dateFixed;
    public boolean fixed = false;

    public Maintenance() {
    }

    public Maintenance(String hostel, String wing, String issue) {
        this.hostel = hostel;
        this.wing = wing;
        this.issue = issue;
        this.datePosted = datePosted;
    }
}
