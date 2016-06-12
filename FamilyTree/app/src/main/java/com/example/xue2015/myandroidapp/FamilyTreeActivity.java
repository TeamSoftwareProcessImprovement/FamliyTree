package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xue2015.myandroidapp.draw.DrawRelativeLine;
import com.example.xue2015.myandroidapp.draw.DrawView;
import com.example.xue2015.myandroidapp.draw.FamilyNode;

public class FamilyTreeActivity extends Activity {
    private Button addFamilyButton;
    private Button deleteFamilyButton;
    private float screemWidth;
    private float screemHeight;
    private float initTop;
    private float initLeft;
    private FrameLayout fl;
//    private ScrollView sv;

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


        ///get the width and height of the screen
        WindowManager wm = this.getWindowManager();
        screemHeight = wm.getDefaultDisplay().getHeight();
        screemWidth = wm.getDefaultDisplay().getWidth();
        initLeft = screemWidth/2-100;
        initTop = screemHeight - 450;

        //FrameLayout add DrawView
        fl = (FrameLayout) findViewById(R.id.familyTreeFrameLayout);
        //ScrollView
//        sv = (ScrollView) findViewById(R.id.familyTreeScrollView);
        drawInitNode();

        drawParentNode(initLeft,initTop);

//        drawParentNode(initLeft + 100 - 150 -100 +300,initTop - 50 - 50 - 250);





        addFamilyButton = (Button) findViewById(R.id.addFamilyButton);
        deleteFamilyButton = (Button) findViewById(R.id.deleteFamilyButton);

        addFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add Family Menber
//                Intent it  = new Intent(FamilyTreeActivity.this,AddFamilyMember.class);
//                startActivity(it);
                drawParentNode(initLeft + 100 - 150 -100 +300,initTop - 50 - 50 - 250);
            }
        });

        deleteFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete Family Memeber
            }
        });
    }

    public void drawInitNode(){
        DrawView dw = new DrawView(this);
        dw.setLeftPos(initLeft);
        dw.setTopPos(initTop);
        dw.setGeneration("Me");
        dw.setName("XueYifei");
        FrameLayout.LayoutParams tparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fl.addView(dw,tparams);
//        sv.addView(fl);
    }

    public void drawParentNode(float childLeft, float childTop){
        //param should be the FamilyNode

        //specify the parentNode pos
        float fatherLeft = childLeft + 100 - 150 -100;
        float fatherTop = childTop - 50 - 50 - 250;
        float motherLeft = fatherLeft + 300;
        float motherTop = fatherTop;
        //draw line
        DrawRelativeLine drawRelativeLine = new DrawRelativeLine(this);

        if(fatherLeft < 0){         //father mode
            fatherLeft = childLeft;
            motherLeft = fatherLeft + 300;
            drawRelativeLine.setDrawMode(1);
        }
        if(motherLeft+200 > screemWidth){       //mother mode
            motherLeft = childLeft;
            fatherLeft = motherLeft - 300;
            drawRelativeLine.setDrawMode(2);
        }

        //draw frame
        DrawView fatherDraw = new DrawView(this);
        fatherDraw.setTopPos(fatherTop);
        fatherDraw.setLeftPos(fatherLeft);
        fatherDraw.setGeneration("Father");
        fatherDraw.setName("XueYanGui");

        DrawView motherDraw = new DrawView(this);
        motherDraw.setLeftPos(motherLeft);
        motherDraw.setTopPos(motherTop);
        motherDraw.setGeneration("Mother");
        motherDraw.setName("HeLiLin");

//        drawRelativeLine.setDrawMode(0);
        drawRelativeLine.setChildLeft(childLeft);
        drawRelativeLine.setChildTop(childTop);

        //add into FL
        FrameLayout.LayoutParams tparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fl.addView(fatherDraw,tparams);
        fl.addView(motherDraw,tparams);
        fl.addView(drawRelativeLine,tparams);

//        sv.addView(fl);
    }

}
