package com.rdb.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import androidx.annotation.NonNull;

public class ColorCornerDrawable extends ColorShapeDrawable {

    private final float cornerRadius;

    public ColorCornerDrawable(@NonNull ColorStateList colorStateList, float cornerRadius) {
        super(colorStateList);
        this.cornerRadius = cornerRadius;
    }

    public ColorCornerDrawable(@NonNull ColorStateList colorStateList, float cornerRadius, float strokeWidth, ColorStateList strokeColorStateList) {
        super(colorStateList, strokeWidth, strokeColorStateList);
        this.cornerRadius = cornerRadius;
    }

    @Override
    protected void draw(Canvas canvas, RectF rectF, Paint paint) {
        float cornerRadius = Math.max(0, Math.min(this.cornerRadius, Math.min(rectF.width(), rectF.height()) / 2));
        if (cornerRadius > 0) {
            canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        } else {
            canvas.drawRect(rectF, paint);
        }
    }

    @Override
    protected void drawStroke(Canvas canvas, RectF rectF, Paint paint, float strokeWidth) {
        float cornerRadius = Math.max(0, Math.min(this.cornerRadius - strokeWidth / 2, Math.min(rectF.width(), rectF.height()) / 2));
        RectF newRectF = new RectF(rectF.left + strokeWidth / 2, rectF.top + strokeWidth / 2, rectF.right - strokeWidth / 2, rectF.bottom - strokeWidth / 2);
        if (cornerRadius > 0) {
            canvas.drawRoundRect(newRectF, cornerRadius, cornerRadius, paint);
        } else {
            canvas.drawRect(newRectF, paint);
        }
    }
}
