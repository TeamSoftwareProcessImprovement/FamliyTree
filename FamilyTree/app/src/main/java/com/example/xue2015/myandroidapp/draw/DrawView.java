package com.example.xue2015.myandroidapp.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.xue2015.myandroidapp.R;

/**
 * Created by Xue on 2016/6/11.
 */

public class DrawView extends View{
    public float leftPos = 40;
    public float topPos = 40;

    public float getTopPos() {
        return topPos;
    }

    public float getLeftPos() {
        return leftPos;
    }

    public void setTopPos(float topPos) {
        this.topPos = topPos;
    }

    public void setLeftPos(float leftPos) {
        this.leftPos = leftPos;
    }

    public DrawView(Context context){
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        float left = leftPos;
        float top = topPos;

        drawFTNode(canvas,left,top);
//        drawFTNode(canvas,400,top);
//        drawLineToEach(canvas,left,top,400, top);
//
//        Paint paint = new Paint();
//        paint.setStrokeWidth(4);
//        paint.setColor(Color.GRAY);
//        canvas.drawLine((left+200+400)/2, top+150, (left+200+400)/2,500,paint);
//        drawFTNode(canvas,(left+200+400)/2-100,500);

    }

    public void drawFTNode(Canvas canvas, float left, float top){
        drawNodeFrame(canvas,left,top);
        drawUserImage(canvas,left,top);
        drawUserText(canvas,left,top);
    }

    public void drawNodeFrame(Canvas canvas, float left, float top){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(4);

        float right = left + 200;
        float bottom = top + 200;
        //add  frame

        canvas.drawRect(left,top,right,bottom,paint);
        canvas.drawRect(left,bottom,right,bottom+80,paint);

    }

    public void drawUserImage(Canvas canvas, float left, float top){
        float right = left + 200;
        float bottom = top + 200;

        // add image
        Bitmap bitmap =  BitmapFactory.decodeResource(getResources(), R.drawable.usericon);
        Rect src = new Rect();
        Rect dst = new Rect();
        src.top = 10;
        src.left = 10;
        src.right = 210;
        src.bottom = 210;
        dst.top = (int) top+5;
        dst.left = (int) left+5;
        dst.right = (int) right;
        dst.bottom = (int) bottom;
        canvas.drawBitmap(bitmap,src,dst,null);
    }

    public  void drawUserText(Canvas canvas, float left, float top){
        float right = left + 200;
        float bottom = top + 200;

        //add Text
        Paint paintText = new Paint();
        paintText.setTextSize(20);
        String name = "XueYifei";
        String identity = "Father";

        canvas.drawText(identity,(left + right)/2 - paintText.measureText(identity)/2 ,bottom+30,paintText);
        canvas.drawText(name,(left + right)/2 - paintText.measureText(name)/2,bottom+65,paintText);
    }

    public void drawLineToEach(Canvas canvas, float firstLeft, float firstTop, float secondLeft, float secondTop){
        float startX;
        float startY;
        float stopX;
        float stopY;

        startX = firstLeft + 200;
        startY = firstTop + 150;
        stopX = secondLeft;
        stopY = secondTop + 150;
        Paint paintLine = new Paint();
        paintLine.setStrokeWidth(4);
        paintLine.setColor(Color.GRAY);
        canvas.drawLine(startX, startY, stopX, stopY, paintLine);
    }


}
