package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.draw.FamilyInfo;
import com.example.xue2015.myandroidapp.draw.FamilyMember;
import com.example.xue2015.myandroidapp.draw.FamilyNode;

public class AddFamilyMember extends Activity {
    public EditText addNameText;
    public EditText addAgeText;
    public EditText addGenerationText;
    public EditText addJobText;
    public EditText addGenderText;
    public EditText addDescriptionText;

    public FamilyMember addFamilyMember;
    public static int me = 0;
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

        EditText name = (EditText) findViewById(R.id.addNameText);
        if(me != 0) {
            name.setText(FamilyTreeActivity.FAM_MEM.getName());
            me=0;
        }

        addFamilyMember = new FamilyMember();
        initView();

    }

    public void initView(){
        addNameText = (EditText) findViewById(R.id.addNameText);
        addAgeText = (EditText) findViewById(R.id.addAgeText);
        addGenerationText = (EditText) findViewById(R.id.addGenerationText);
        addJobText = (EditText) findViewById(R.id.addJobText);
        addGenderText = (EditText) findViewById(R.id.addGenderText);
        addDescriptionText = (EditText) findViewById(R.id.addDescriptionText);


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


                addFamilyMember.setName((String) addNameText.getText().toString());
                addFamilyMember.setAge(Integer.parseInt((String)addAgeText.getText().toString()));
//                addFamilyMember.setBrithday();
                addFamilyMember.setGeneration((String) addGenerationText.getText().toString());
                addFamilyMember.setGender((String)addGenderText.getText().toString());
                addFamilyMember.setJob((String)addJobText.getText().toString());

                if(FamilyTreeActivity.FAM_FLAG == 1){
                    FamilyTreeActivity.ADD_MEM = addFamilyMember;
                }
                if(FamilyTreeActivity.FAM_FLAG == 2){
                    FamilyTreeActivity.THI_MEM = addFamilyMember;
                }
                FamilyTreeActivity.FAM_FLAG ++;

                FamilyNode fn = new FamilyNode();
                fn.setMember(addFamilyMember);
                FamilyTreeActivity.FAM_NODES.add(fn);

                Intent it  = new Intent(AddFamilyMember.this,FamilyTreeActivity.class);
//                Bundle mBundle = new Bundle();
//                mBundle.putSerializable(ADD_MEM,addFamilyMember);
//                mBundle.putSerializable(ADD_FLAG,1);
//                it.putExtras(mBundle);
                startActivity(it);
            }
        });

    }
}
