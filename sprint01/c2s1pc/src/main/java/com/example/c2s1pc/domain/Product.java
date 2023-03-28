package com.example.c2s1pc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int pid;
    private String pname;
    private String pdes;
    private int amt;

    public Product() {
    }

    public Product(int pid,String pname,String pdes,int amt) {
        this.pid = pid;
        this.pname=pname;
        this.pdes=pdes;
        this.amt=amt;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdes() {
        return pdes;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdes='" + pdes + '\'' +
                ", amt=" + amt +
                '}';
    }
}
