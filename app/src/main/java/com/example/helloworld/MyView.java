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
    public MyView(Context context) {
        super(context);
        paint = new Paint();
        setBackgroundColor(Color.WHITE);
        ViewTimer timer = new ViewTimer(this);
        timer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        iNr++;
        canvas.drawText("frame " + iNr,100,100,paint);
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
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
