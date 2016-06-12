package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/11.
 */
public class I extends Activity {
    private RelativeLayout chang_psw,myInfo,feedback,myBind;
    private Button setting,exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.left_drawer_fragment);
        initView();

        RelativeLayout tree = (RelativeLayout) findViewById(R.id.main_page_bottom_button_mainpage3);
        RelativeLayout circle = (RelativeLayout) findViewById(R.id.main_page_bottom_button_pointshop3);
        RelativeLayout connect = (RelativeLayout) findViewById(R.id.main_page_bottom_button_questionnairecenter3);

        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(I.this,FamilyTreeActivity.class);
                startActivity(it);
            }
        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(I.this,ConnectActivity.class);
                startActivity(it);
            }
        });
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(I.this,ConnectActivity.class);
                startActivity(it);
            }
        });
    }

    private void initView() {
        chang_psw =(RelativeLayout)findViewById(R.id.change_psw);
        chang_psw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(I.this, ChangePswActivity.class);
                I.this.startActivity(it);
            }
        });

        myInfo =(RelativeLayout)findViewById(R.id.my_info);
        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(I.this, ChangeInfoActivity.class);
                I.this.startActivity(it);
            }
        });

        myBind =(RelativeLayout)findViewById(R.id.my_bind);
        myBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(I.this, MyBindingActivity.class);
                I.this.startActivity(it);
            }
        });


        feedback =(RelativeLayout)findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(I.this, QuestionFeedbackActivity.class);
                I.this.startActivity(it);
            }
        });

//        setting =(Button)findViewById(R.id.buttonSetting);
//        setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent(I.this, SettingsActivity.class);
//                I.this.startActivity(it);
//            }
//        });
//
//        exit =(Button)findViewById(R.id.buttonExit);
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent(I.this, MainActivity.class);
//                I.this.startActivity(it);
//            }
//        });
    }
}
