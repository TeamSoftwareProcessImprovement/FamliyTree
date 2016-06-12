package com.example.xue2015.myandroidapp.draw;

import java.io.Serializable;

/**
 * Created by MyPC on 2016/6/12.
 */

public class FamilyNode implements Serializable {
    private int id;
    private FamilyMember member;
    private int father;
    private int mother;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FamilyMember getMember() {
        return member;
    }

    public void setMember(FamilyMember member) {
        this.member = member;
    }

    public int getFather() {
        return father;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public int getMother() {
        return mother;
    }

    public void setMother(int mother) {
        this.mother = mother;
    }
}
