package com.mrone.heapdump.entity;


import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    private int age;
    private String address;
    private static List<Like> allLikes = new ArrayList<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public User(int id, String name, int age, String address, Like like) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        allLikes.add(like);
    }

    public User() {}
}
