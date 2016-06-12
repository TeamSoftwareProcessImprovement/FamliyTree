package com.example.xue2015.myandroidapp.draw;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xue on 2016/6/12.
 */
public class FamilyInfo implements Serializable {
    private static final long serialVersionUID = -7060210544600464481L;
    private List<FamilyNode> familyNodesList;
    private FamilyMember me;
    private int counter;

    public List<FamilyNode> getFamilyNodesList() {
        return familyNodesList;
    }

    public FamilyMember getMe() {
        return me;
    }

    public void setFamilyNodesList(List<FamilyNode> familyNodesList) {
        this.familyNodesList = familyNodesList;
    }

    public void setMe(FamilyMember me) {
        this.me = me;
    }

    public FamilyInfo(List<FamilyNode> familyNodesList, FamilyMember me) {
        this.familyNodesList = familyNodesList;
        this.me = me;
        counter = 0;
    }

    public FamilyInfo(){
        familyNodesList = new ArrayList<FamilyNode>();
        me = new FamilyMember();
        counter = 0;
    }

    public void  addFamliyMember(FamilyMember fm){
        FamilyNode familyNode = new FamilyNode();
        familyNode.setMember(fm);
        familyNode.setId(counter);
        familyNodesList.add(familyNode);
        counter ++;
    }


}
