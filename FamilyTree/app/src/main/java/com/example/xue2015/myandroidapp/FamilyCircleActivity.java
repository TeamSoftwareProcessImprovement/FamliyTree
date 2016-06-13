package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
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
    }
}
