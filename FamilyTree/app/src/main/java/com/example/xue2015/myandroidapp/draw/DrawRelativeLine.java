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

    public DrawRelativeLine(Context context){
        super(context);
    }

    public DrawRelativeLine(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    public void onDraw(Canvas canvas){

    }

    public void drawLineSameDegree(Canvas canvas){
        Paint paintLine = new Paint();
        paintLine.setStrokeWidth(4);
        paintLine.setColor(Color.GRAY);
        canvas.drawLine(firstLeft,firstTop,secondLeft,secondTop,paintLine);
    }

}
