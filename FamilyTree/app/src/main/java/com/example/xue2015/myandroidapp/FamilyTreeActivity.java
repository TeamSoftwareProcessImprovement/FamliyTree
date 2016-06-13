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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xue2015.myandroidapp.draw.DrawRelativeLine;
import com.example.xue2015.myandroidapp.draw.DrawView;
import com.example.xue2015.myandroidapp.draw.FamilyInfo;
import com.example.xue2015.myandroidapp.draw.FamilyMember;
import com.example.xue2015.myandroidapp.draw.FamilyNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeActivity extends Activity {
    private Button addFamilyButton;
    private Button deleteFamilyButton;
    private float screemWidth;
    private float screemHeight;
    private float initTop;
    private float initLeft;
    private FrameLayout fl;
//    private
    public static int  FAM_FLAG = 1;
    public static FamilyMember FAM_MEM;
    public static FamilyMember ADD_MEM;
    public static List<FamilyNode> FAM_NODES = new ArrayList<FamilyNode>();
//    public static FamilyNode FAM_NODES[] = new FamilyNode[5];
    public static FamilyMember THI_MEM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_family_tree);

        initFamily();

        //init TitleBar
        initTitle();
        Titlebar tb = (Titlebar) findViewById(R.id.familyTreeTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("家谱树");
        tb.hideLeft();
        tb.hideRight();

        RelativeLayout connect = (RelativeLayout) findViewById(R.id.main_page_bottom_button_questionnairecenter);
        RelativeLayout circle = (RelativeLayout) findViewById(R.id.main_page_bottom_button_pointshop);
        RelativeLayout me = (RelativeLayout) findViewById(R.id.main_page_bottom_button_push);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                List<FamilyNode> connectFanilyList = new ArrayList<FamilyNode>();
//                connectFanilyList = FAM_NODES;
//                System.out.print(FAM_NODES.size());
//                String te = String.valueOf(FAM_NODES.size());
//                Toast.makeText(getApplicationContext(),te ,
//                        Toast.LENGTH_SHORT).show();
                Intent it  = new Intent(FamilyTreeActivity.this,ConnectActivity.class);
//                it.putExtra("connectFanilyList", (Serializable) connectFanilyList);
                startActivity(it);
            }
        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(FamilyTreeActivity.this,FamilyCircleActivity.class);
                startActivity(it);
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it  = new Intent(FamilyTreeActivity.this,I.class);
                startActivity(it);
            }
        });
//        initView();



        ///get the width and height of the screen
        WindowManager wm = this.getWindowManager();
        screemHeight = wm.getDefaultDisplay().getHeight();
        screemWidth = wm.getDefaultDisplay().getWidth();
        initLeft = screemWidth/2-100;
        initTop = screemHeight - 450 -50;

        //FrameLayout add DrawView
        fl = (FrameLayout) findViewById(R.id.familyTreeFrameLayout);


        if(FamilyTreeActivity.FAM_FLAG == 1){
            drawInitNode();
        }else if(FamilyTreeActivity.FAM_FLAG == 2){
            drawInitNode();
            drawParentNode(initLeft,initTop);
        }else if(FamilyTreeActivity.FAM_FLAG == 3){
            drawInitNode();
            drawParentNode(initLeft,initTop);
            if (FamilyTreeActivity.ADD_MEM.getGender().equals("男")){
                drawThirdParentNodes(initLeft + 100 - 150 -100, initTop - 50 - 50 - 250);
            }else if(FamilyTreeActivity.ADD_MEM.getGender().equals("女")){
                drawThirdParentNodes(initLeft + 100 - 150 -100 +300, initTop - 50 - 50 - 250);
            }
        }

        addFamilyButton = (Button) findViewById(R.id.addFamilyButton);
        addFamilyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add Family Menber
                Intent it  = new Intent(FamilyTreeActivity.this,AddFamilyMember.class);
                startActivity(it);
//                drawParentNode(initLeft + 100 - 150 -100 +300,initTop - 50 - 50 - 250);
            }
        });


    }

    public void initFamily(){
        FamilyNode temp = new FamilyNode();
        temp.setId(1);
        temp.setMember(FamilyTreeActivity.FAM_MEM);
//        FamilyTreeActivity.FAM_NODES[0] = temp;
        if (!FamilyTreeActivity.FAM_NODES.contains(temp)){
            FamilyTreeActivity.FAM_NODES.add(temp);
        }

//        FamilyNode temp1 = new FamilyNode();
//        temp1.setMember(ADD_MEM);
//        FamilyTreeActivity.FAM_NODES.add(temp1);
    }


    public void initTitle(){
        Titlebar tb = (Titlebar) findViewById(R.id.familyTreeTitle);
        TextView tv = (TextView) tb.findViewById(R.id.textAxtionBarTitle);
        tv.setText("家谱树");
        tb.hideLeft();
        tb.hideRight();
    }

    public void drawInitNode(){
        DrawView dw = new DrawView(this);
        dw.setLeftPos(initLeft);
        dw.setTopPos(initTop);

//        dw.setGeneration(fm.getGender());
//        dw.setName(fm.getName());
        dw.setGeneration("Me");
//        dw.setName("XueYifei");
        String meName = FamilyTreeActivity.FAM_MEM.getName();
        dw.setName(meName);
        FrameLayout.LayoutParams tparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fl.addView(dw,tparams);
//        sv.addView(fl);
    }

    public void drawParentNode(float childLeft, float childTop){
        //param should be the FamilyNode
//        FamilyMember fm = (FamilyMember) getIntent().getSerializableExtra(AddFamilyMember.ADD_MEM);

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

//        fatherDraw.setGeneration(fm.getGender());
//        fatherDraw.setName(fm.getName());



        DrawView motherDraw = new DrawView(this);
        motherDraw.setLeftPos(motherLeft);
        motherDraw.setTopPos(motherTop);


        if(FamilyTreeActivity.ADD_MEM.getGender().equals("男")){
            fatherDraw.setGeneration("Father");
            fatherDraw.setName(FamilyTreeActivity.ADD_MEM.getName());
            motherDraw.setGeneration("Mother");
            motherDraw.setName("Name");
        }else if(FamilyTreeActivity.ADD_MEM.getGender().equals("女")){
            fatherDraw.setGeneration("Father");
            fatherDraw.setName("Name");
            motherDraw.setGeneration("Mother");
            motherDraw.setName(FamilyTreeActivity.ADD_MEM.getName());
        }else{
            fatherDraw.setGeneration("Father");
            fatherDraw.setName("Name");
            motherDraw.setGeneration("Mother");
            motherDraw.setName("Name");
        }

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

    public void drawThirdParentNodes(float childLeft, float childTop){
        //param should be the FamilyNode
//        FamilyMember fm = (FamilyMember) getIntent().getSerializableExtra(AddFamilyMember.ADD_MEM);

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

//        fatherDraw.setGeneration(fm.getGender());
//        fatherDraw.setName(fm.getName());



        DrawView motherDraw = new DrawView(this);
        motherDraw.setLeftPos(motherLeft);
        motherDraw.setTopPos(motherTop);



        if(FamilyTreeActivity.THI_MEM.getGender().equals("男")){
            fatherDraw.setGeneration("Grandpa");
            fatherDraw.setName(FamilyTreeActivity.THI_MEM.getName());
            motherDraw.setGeneration("Grandma");
            motherDraw.setName("Name");
        }else if(FamilyTreeActivity.THI_MEM.getGender().equals("女")){
            fatherDraw.setGeneration("Grandpa");
            fatherDraw.setName("Name");
            motherDraw.setGeneration("Grandma");
            motherDraw.setName(FamilyTreeActivity.THI_MEM.getName());
        }else{
            fatherDraw.setGeneration("Grandpa");
            fatherDraw.setName("Name");
            motherDraw.setGeneration("Grandma");
            motherDraw.setName("Name");
        }

//        drawRelativeLine.setDrawMode(0);
        drawRelativeLine.setChildLeft(childLeft);
        drawRelativeLine.setChildTop(childTop);

        //add into FL
        FrameLayout.LayoutParams tparams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fl.addView(fatherDraw,tparams);
        fl.addView(motherDraw,tparams);
        fl.addView(drawRelativeLine,tparams);

    }


}
