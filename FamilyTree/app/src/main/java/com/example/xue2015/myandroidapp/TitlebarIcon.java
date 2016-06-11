package com.example.xue2015.myandroidapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by xue2015 on 2015/7/26.
 */
public class TitlebarIcon extends LinearLayout{
    ImageButton Left;
    ImageButton Right;

    public TitlebarIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titlebar_icon_top, this);

        ImageButton left = (ImageButton) findViewById(R.id.imageViewActionBarLeft);
        ImageButton right = (ImageButton) findViewById(R.id.imageViewActionBarRight);

        Left = left;
        Right = right;

//        left.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 添加图标的跳转事件，跳转到“抽屉”界面
//                //Intent来实现
//
//
//            }
//        });
//
//        right.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //添加图标的跳转事件，跳转到“我的问友”界面
//
//            }
//        });



    }


    public ImageButton getLeftIcon(){
        return Left;
    }

    public ImageButton getRightIcon(){
        return Right;
    }

}

