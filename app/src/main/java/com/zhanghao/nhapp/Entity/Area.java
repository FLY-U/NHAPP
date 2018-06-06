package com.zhanghao.nhapp.Entity;

public class Area {
    public Area(){

    }
    public Area(String Name){
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;
}
