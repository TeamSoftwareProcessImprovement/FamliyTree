package com.example.xue2015.myandroidapp.draw;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by MyPC on 2016/6/12.
 */
public class Tree {
    public List<FamilyNode> list = new ArrayList<FamilyNode>();
    public void setlist(){
        FamilyMember member1 = new FamilyMember();
        FamilyMember member2 = new FamilyMember();
        FamilyMember member3 = new FamilyMember();
        member1.setName("aaa");
        member2.setName("bbb");
        member3.setName("bbb");
        FamilyNode node1= new FamilyNode();
        FamilyNode node2= new FamilyNode();
        FamilyNode node3= new FamilyNode();
        node1.setMember(member1);
        node1.setId(1);
        node1.setFather(2);
        node1.setMother(3);
        node2.setMember(member2);
        node2.setId(2);
        node3.setMember(member3);
        node3.setId(3);
        list.add(node1);
        list.add(node2);
        list.add(node3);
    }

    public List<String> AllName(){
        List<String> name = new ArrayList<String>();
        Stack<FamilyNode> s = new Stack<FamilyNode>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==1){
                s.push(list.get(i));
                break;
            }
        }
        while (!s.isEmpty()) {
            FamilyNode node = s.pop();
            String now = node.getMember().getName();
            name.add(now);
            s.addAll(getChild( node));
        }
        return name;
    }
    public List<FamilyNode> getChild(FamilyNode node){
        List<FamilyNode> parents = new ArrayList<FamilyNode>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==node.getFather()){
                parents.add(list.get(i));
                break;
            }
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==node.getMother()){
                parents.add(list.get(i));
                break;
            }
        }
        return parents;
    }
}
