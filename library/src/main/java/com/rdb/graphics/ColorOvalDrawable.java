package com.rdb.graphics;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;

public class ColorOvalDrawable extends ColorShapeDrawable {

    public ColorOvalDrawable(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
    }

    public ColorOvalDrawable(@NonNull ColorStateList colorStateList, float strokeWidth, ColorStateList strokeColorStateList) {
        super(colorStateList, strokeWidth, strokeColorStateList);
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
