package com.example.xue2015.myandroidapp.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.R;
import com.example.xue2015.myandroidapp.Titlebar;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_family_member);

        Titlebar tb = (Titlebar) findViewById(R.id.addFamilyLayoutTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("个人信息");
//        tb.hideLeft();
        tb.hideRight();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        EditText username = (EditText) findViewById(R.id.addNameText);
        EditText age = (EditText) findViewById(R.id.addAgeText);
        EditText genaretion = (EditText) findViewById(R.id.addGenerationText);
        EditText gender = (EditText) findViewById(R.id.addGenderText);
        EditText job = (EditText) findViewById(R.id.addJobText);
        //EditText descript = (EditText) findViewById(R.id.addDescriptionText);
        Button button = (Button) findViewById(R.id.addFamilyOKButton);
        button.setVisibility(View.INVISIBLE);
        switch (name){
            case "小明":username.setText("小明");
                         age.setText("18");
                         genaretion.setText("我");
                         gender.setText("男");
                         job.setText("大学生");
                            break;
            case "小红":username.setText("小红");
                         age.setText("38");
                         genaretion.setText("妈妈");
                         gender.setText("女");
                         job.setText("教师");
                         break;
            case "小丽":username.setText("小丽");
                          age.setText("58");
                          genaretion.setText("奶奶");
                          gender.setText("女");
                          job.setText("教师");
                          break;
        }
    }
}
