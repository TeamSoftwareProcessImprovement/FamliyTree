package com.example.xue2015.myandroidapp.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Xue on 2016/6/11.
 */
public class DrawView extends View{
    public DrawView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(4);

        float left = 50;
        float top = 140;
        float right = left + 200;
        float bottom = top + 200;
        canvas.drawRect(left,top,right,bottom,paint);
        canvas.drawRect(left,bottom,right,bottom+80,paint);

        Paint paintText = new Paint();
        paintText.setTextSize(25);
        canvas.drawText("Father",(left + right)*3/8,bottom+30,paintText);
        canvas.drawText("XueYifei",(left + right)*3/8,bottom+65,paintText);


    }

    public void drawNode(Canvas canvas, float left, float top,float right,float bottom){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(4);
        //add  frame
        canvas.drawRect(left,top,right,bottom,paint);
        canvas.drawRect(left,bottom,right,bottom+80,paint);

        //add Text
        Paint paintText = new Paint();
        paintText.setTextSize(20);
        canvas.drawText("Father",(left + right)*3/8,bottom+30,paintText);
        canvas.drawText("XueYifei",(left + right)*3/8,bottom+65,paintText);

    }
}
