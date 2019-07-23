package com.bawei.cln20190723.weight;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/*
 *@Auther:cln
 *@Date: 2019/7/23
 *@Description:功能
 * */
public class LinearView extends View {

    private Paint paint;

    public LinearView(Context context) {
        this(context,null);
    }

    public LinearView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LinearView(Context context, AttributeSet attrs, int defStyleAttr) {
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

}
