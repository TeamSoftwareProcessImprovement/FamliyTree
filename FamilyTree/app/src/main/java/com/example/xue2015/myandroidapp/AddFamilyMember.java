package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddFamilyMember extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_family_member);

        Titlebar tb = (Titlebar) findViewById(R.id.familyTreeTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("添加成员");
        tb.hideLeft();
        tb.hideRight();
        initView();
    }

    public void initView(){
        LinearLayout addNameClick = (LinearLayout) findViewById(R.id.addNameClick);
        LinearLayout addAgeClick = (LinearLayout) findViewById(R.id.addAgeClick);
        LinearLayout addGenerationClick = (LinearLayout) findViewById(R.id.addGenerationClick);
        LinearLayout addGenderClick = (LinearLayout) findViewById(R.id.addGenderClick);
        LinearLayout addJobClick = (LinearLayout) findViewById(R.id.addJobClick);
        LinearLayout addDescriptionClick = (LinearLayout) findViewById(R.id.addDescriptionClick);

        addNameClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to addNameClick
            }
        });

        addAgeClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to addAgeClick
            }
        });

        addGenerationClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to addGenerationClick
            }
        });

        addGenderClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to addGenderClick
            }
        });

        addJobClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to addJobClick
            }
        });

        addDescriptionClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to addDescriptionClick
            }
        });

    }
}
