package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.draw.DrawView;

public class FamilyTreeActivity extends Activity {
    private Button addFamilyButton;
    private Button deleteFamilyButton;
    private float screemWidth;
    private float screemHeight;
    private float initTop;
    private float initLeft;

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

//        initView();
        addFamilyButton = (Button) findViewById(R.id.addFamilyButton);
        deleteFamilyButton = (Button) findViewById(R.id.deleteFamilyButton);

        addFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add Family Menber
                Intent it  = new Intent(FamilyTreeActivity.this,AddFamilyMember.class);
                startActivity(it);
            }
        });

        deleteFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete Family Memeber
            }
        });

        //FrameLayout add DrawView
        FrameLayout fl = (FrameLayout) findViewById(R.id.familyTreeFrameLayout);
        drawInitNode(fl);

    }

    public void drawInitNode(FrameLayout fl){
        ///get the width and height of the screen
        WindowManager wm = this.getWindowManager();
        screemHeight = wm.getDefaultDisplay().getHeight();
        screemWidth = wm.getDefaultDisplay().getWidth();
        initLeft = screemWidth/2-100;
        initTop = screemHeight - 450;

        DrawView dw = new DrawView(this);
        dw.setLeftPos(initLeft);
        dw.setTopPos(initTop);
        FrameLayout.LayoutParams tparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fl.addView(dw,tparams);
    }

    public void drawParentNode(){

    }

}
