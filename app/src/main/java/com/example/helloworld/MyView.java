package com.example.helloworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    int iNr=0;
    Paint paint;
    long startTime;
    public MyView(Context context) {
        super(context);
        paint = new Paint();
        setBackgroundColor(Color.WHITE);
        ViewTimer timer = new ViewTimer(this);
        timer.start();
        startTime =System.currentTimeMillis();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        iNr++;
        canvas.drawText("frame " + iNr,100,100,paint);
        canvas.drawText("fps " + iNr*1000/(System.currentTimeMillis() - startTime),100,300,paint);
    }
    private class ViewTimer extends Thread
    {
        View view;
        public ViewTimer(View view)
        {
            this.view = view;
        }

        @Override
        public void run() {
            while (true) {
                view.invalidate();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
