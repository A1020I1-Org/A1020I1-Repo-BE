package com.example.demo.entity;

public class DataForComputer {
    private int name;
    private int time;

    public DataForComputer(int name, int time) {
        this.name = name;
        this.time = time;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
