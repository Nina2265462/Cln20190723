package com.bawei.cln20190723.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/*
 *@Auther:cln
 *@Date: 2019/7/23
 *@Description:功能
 * */
public class DotView extends View {

    private Paint paint;
    private float x;
    private float y;

    public DotView(Context context) {
        this(context, null);
    }

    public DotView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);//颜色
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, 50, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:

                x = event.getX();
                y = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                x = 0;
                y = 0;
                break;

        }
        postInvalidate();

        return true;

    }
}
