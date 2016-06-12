package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.draw.FamilyInfo;
import com.example.xue2015.myandroidapp.draw.FamilyMember;

public class AddFamilyMember extends Activity {
    public TextView addNameText;
    public TextView addAgeText;
    public TextView addGenerationText;
    public TextView addJobText;
    public TextView addGenderText;
    public TextView addDescriptionText;

    public FamilyMember addFamilyMember;
    public  final static String ADD_MEM = "com.xue.addMem.ser";
    public  final static String ADD_FLAG = "com.xue.addFlag.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_family_member);

        Titlebar tb = (Titlebar) findViewById(R.id.addFamilyLayoutTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("个人信息");
        tb.hideLeft();
        tb.hideRight();


        addFamilyMember = new FamilyMember();
        initView();

    }

    public void initView(){
        addNameText = (TextView) findViewById(R.id.addNameText);
        addAgeText = (TextView) findViewById(R.id.addAgeText);
        addGenerationText = (TextView) findViewById(R.id.addGenerationText);
        addJobText = (TextView) findViewById(R.id.addJobText);
        addGenderText = (TextView) findViewById(R.id.addGenderText);
        addDescriptionText = (TextView) findViewById(R.id.addDescriptionText);


        LinearLayout addNameClick = (LinearLayout) findViewById(R.id.addNameClick);
        LinearLayout addAgeClick = (LinearLayout) findViewById(R.id.addAgeClick);
        LinearLayout addGenerationClick = (LinearLayout) findViewById(R.id.addGenerationClick);
        LinearLayout addGenderClick = (LinearLayout) findViewById(R.id.addGenderClick);
        LinearLayout addJobClick = (LinearLayout) findViewById(R.id.addJobClick);
        LinearLayout addDescriptionClick = (LinearLayout) findViewById(R.id.addDescriptionClick);
        Button addFamilyOKButton = (Button) findViewById(R.id.addFamilyOKButton);

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

        addFamilyOKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // add family

                addFamilyMember.setName((String) addNameText.getText());
                addFamilyMember.setAge(Integer.parseInt((String)addAgeText.getText()));
//                addFamilyMember.setBrithday();
                addFamilyMember.setGeneration((String) addGenerationText.getText());
                addFamilyMember.setGender((String)addGenderText.getText());
                addFamilyMember.setJob((String)addJobText.getText());
                Intent it  = new Intent(AddFamilyMember.this,FamilyTreeActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable(ADD_MEM,addFamilyMember);
                mBundle.putSerializable(ADD_FLAG,1);
                it.putExtras(mBundle);
                startActivity(it);
            }
        });

    }
}
