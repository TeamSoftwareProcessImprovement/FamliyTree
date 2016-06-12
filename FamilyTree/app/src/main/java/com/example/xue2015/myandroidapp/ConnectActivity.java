package com.example.xue2015.myandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.xue2015.myandroidapp.draw.FamilyMember;
import com.example.xue2015.myandroidapp.draw.FamilyNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class ConnectActivity extends AppCompatActivity {
    public List<FamilyNode> list = new ArrayList<FamilyNode>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        ListView listView = (ListView) findViewById(R.id.listView2);
        //List<Map<String,String>> listitems = new ArrayList<Map<String,String>>();
        setlist();
        List<String> name = Order();
        //List<String> name = new ArrayList<String>() ;

        String[] name1= name.toArray(new String[name.size()]);
//        for(int i=0;i<list.size();i++){
//            Map<String,String> map = new HashMap<String,String>();
//            map.put("name",name.get(i));
//            listitems.add(map);
//        }
//        SimpleAdapter adapter = new SimpleAdapter(this,listitems,R.layout.connect_items,new String[]{"name"},new int[]{R.id.connectname});
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name1);
        listView.setAdapter(adapter);

    }

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

    public List<String> Order(){
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