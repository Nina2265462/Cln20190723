package com.bawei.cln20190723.weight;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *@Auther:cln
 *@Date: 2019/7/23
 *@Description:功能
 * */
public class DotRandomView extends View {

    private Paint paint1, paint2, paint3;
    List<Point> list = new ArrayList<>();

    public DotRandomView(Context context) {
        this(context, null);
    }

    public DotRandomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DotRandomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint1 = new Paint();
        paint1.setColor(Color.RED);//颜色
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
        paint1.setDither(true);
        paint2 = new Paint();
        paint2.setColor(Color.GREEN);//颜色
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint3 = new Paint();
        paint3.setColor(Color.CYAN);//颜色
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint3.setDither(true);
    }

    private int x, y;
    private int destX, destY;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Point point : list) {
            if (point.x > x && point.x < destX && point.y > y && point.y < destY) {
                canvas.drawCircle(point.x, point.y, 10, paint3);
            } else {
                canvas.drawCircle(point.x, point.y, 10, paint1);
            }

        }

        canvas.drawRect(x, y, destX, destY, paint2);
    }

    public void addDot() {
        int cx = new Random().nextInt(getScreenWidthOrHeight(true));
        int cy = new Random().nextInt(getScreenWidthOrHeight(false));
        Point point = new Point();
        point.x = cx;
        point.y = cy;
        list.add(point);
        invalidate();
    }
    public void deleteDot() {
        int cx = new Random().nextInt(getScreenWidthOrHeight(true));
        int cy = new Random().nextInt(getScreenWidthOrHeight(false));
        Point point = new Point();
        point.x = cx;
        point.y = cy;
        list.clear();
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = (int) event.getX();
                y = (int) event.getY();

                break;
            case MotionEvent.ACTION_MOVE:

                destX = (int) event.getX();
                destY = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return true;

    }

    public int getScreenWidthOrHeight(boolean width) {
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (width) {
            return dm.widthPixels;
        } else {
            return dm.heightPixels;
        }

    }
}
