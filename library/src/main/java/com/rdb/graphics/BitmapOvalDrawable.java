package com.rdb.graphics;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;

public class BitmapOvalDrawable extends BitmapShapeDrawable {

    public BitmapOvalDrawable(Bitmap bitmap) {
        this(bitmap, 0, null);
    }

    public BitmapOvalDrawable(@NonNull Bitmap bitmap, float strokeWidth, ColorStateList strokeColorStateList) {
        super(bitmap, strokeWidth, strokeColorStateList);
    }

    @Override
    protected void draw(Canvas canvas, RectF rectF, Paint paint) {
        canvas.drawOval(rectF, paint);
    }

    @Override
    protected void drawStroke(Canvas canvas, RectF rectF, Paint paint, float strokeWidth) {
        RectF newRectF = new RectF(rectF.left + strokeWidth / 2, rectF.top + strokeWidth / 2, rectF.right - strokeWidth / 2, rectF.bottom - strokeWidth / 2);
        canvas.drawOval(newRectF, paint);
    }
}
