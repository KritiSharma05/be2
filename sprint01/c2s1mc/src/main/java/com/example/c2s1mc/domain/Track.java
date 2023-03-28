package com.example.c2s1mc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    private int tid;
    private String tname;
    private String tcom;
    private String trate;
    private String tart;

    public Track() {
    }

    public Track(int tid,String tname,String trate,String tart) {
        this.tid = tid;
        this.tname=tname;
        this.trate=trate;
        this.tart=tart;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTcom() {
        return tcom;
    }

    public void setTcom(String tcom) {
        this.tcom = tcom;
    }

    public String getTrate() {
        return trate;
    }

    public void setTrate(String trate) {
        this.trate = trate;
    }

    public String getTart() {
        return tart;
    }

    public void setTart(String tart) {
        this.tart = tart;
    }

    @Override
    public String toString() {
        return "Track{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tcom='" + tcom + '\'' +
                ", trate=" + trate +
                ", tart='" + tart + '\'' +
                '}';
    }
}
