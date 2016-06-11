package com.example.xue2015.myandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class FamilyTreeActivity extends AppCompatActivity {
    private Button addFamilyButton;
    private Button deleteFamilyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_family_tree);

        Titlebar tb = (Titlebar) findViewById(R.id.familyTreeTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("家谱树");
        tb.hideLeft();
        tb.hideRight();

        initView();


    }

    public void initView(){
        addFamilyButton = (Button) findViewById(R.id.addFamilyButton);
        deleteFamilyButton = (Button) findViewById(R.id.deleteFamilyButton);

        addFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add Family Menber
            }
        });

        deleteFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete Family Memeber
            }
        });
    }


}
