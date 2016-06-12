package com.example.xue2015.myandroidapp.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Xue on 2016/6/12.
 */
public class DrawRelativeLine extends View{
    public float firstLeft;
    public float firstTop;
    public float secondLeft;
    public float secondTop;

    public float childLeft;
    public float childTop;

    public float getFirstLeft() {
        return firstLeft;
    }

    public float getFirstTop() {
        return firstTop;
    }

    public float getSecondLeft() {
        return secondLeft;
    }

    public float getSecondTop() {
        return secondTop;
    }

    public float getChildLeft() {
        return childLeft;
    }

    public float getChildTop() {
        return childTop;
    }

    public void setFirstLeft(float firstLeft) {
        this.firstLeft = firstLeft;
    }

    public void setFirstTop(float firstTop) {
        this.firstTop = firstTop;
    }

    public void setSecondLeft(float secondLeft) {
        this.secondLeft = secondLeft;
    }

    public void setSecondTop(float secondTop) {
        this.secondTop = secondTop;
    }

    public void setChildLeft(float childLeft) {
        this.childLeft = childLeft;
    }

    public void setChildTop(float childTop) {
        this.childTop = childTop;
    }

    public DrawRelativeLine(Context context){
        super(context);
    }

    public DrawRelativeLine(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public void onDraw(Canvas canvas){
        float childLeftPos = childLeft;
        float childTopPos = childTop;
        drawParentLine(canvas,childLeftPos,childTopPos);
    }

    public void drawLineSameDegree(Canvas canvas){
        Paint paintLine = new Paint();
        paintLine.setStrokeWidth(4);
        paintLine.setColor(Color.GRAY);
        canvas.drawLine(firstLeft,firstTop,secondLeft,secondTop,paintLine);
    }

    public void drawParentLine(Canvas canvas,float childLeft, float childTop){
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(4);

        canvas.drawLine(childLeft+100 ,childTop,childLeft+100, childTop-25,paint);
        canvas.drawLine(childLeft-50 ,childTop-25,childLeft+250, childTop-25,paint);
        canvas.drawLine(childLeft-50 ,childTop-25,childLeft-50, childTop-70,paint);
        canvas.drawLine(childLeft+250 ,childTop-25,childLeft+250, childTop-70,paint);
    }

}
