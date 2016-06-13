package com.example.xue2015.myandroidapp.draw;

import java.io.Serializable;

/**
 * Created by Xue on 2016/6/11.
 */

public class FamilyMember implements Serializable{
    public String name = "";
    public String generation;
    public String gender;
    public int age;
    public String job;
    public String brithday;

    public String description;

    public String getName() {
        return name;
    }

    public String getGeneration() {
        return generation;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getBrithday() {
        return brithday;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
