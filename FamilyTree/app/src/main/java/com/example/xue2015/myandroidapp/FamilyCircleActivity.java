package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FamilyCircleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_family_circle);

        Titlebar tb = (Titlebar) findViewById(R.id.familyCircleLayoutTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("家族圈");
//        tb.hideLeft();
        tb.hideRight();

        RelativeLayout familyCircleButtom_familyTree = (RelativeLayout) findViewById(R.id.familyCircleButtom_familyTree);
        RelativeLayout familyCircleButtom_connection = (RelativeLayout) findViewById(R.id.familyCircleButtom_connection);
        RelativeLayout familyCircleButtom_familyMe = (RelativeLayout) findViewById(R.id.familyCircleButtom_familyMe);

        familyCircleButtom_familyTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(FamilyCircleActivity.this,FamilyTreeActivity.class);
                startActivity(it);
            }
        });

        familyCircleButtom_connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(FamilyCircleActivity.this,ConnectActivity.class);
                startActivity(it);
            }
        });

        familyCircleButtom_familyMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(FamilyCircleActivity.this,I.class);
                startActivity(it);
            }
        });

    }
}
