package com.rdb.graphics;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import androidx.annotation.NonNull;

public abstract class ColorShapeDrawable extends StateDrawable {

    private Paint paint;
    private Paint strokePaint;
    private Rect padding;
    private float strokeWidth;
    private boolean strokeEnable;
    private ColorStateList colorStateList;
    private ColorStateList strokeColorStateList;

    public ColorShapeDrawable(@NonNull ColorStateList colorStateList) {
        this(colorStateList, 0, null);
    }

    public ColorShapeDrawable(@NonNull ColorStateList colorStateList, float strokeWidth, ColorStateList strokeColorStateList) {
        paint = new Paint();
        paint.setAntiAlias(true);
        this.colorStateList = colorStateList;
        strokeEnable = strokeWidth > 0 && strokeColorStateList != null;
        if (strokeEnable) {
            this.strokeWidth = strokeWidth;
            strokePaint = new Paint();
            strokePaint.setAntiAlias(true);
            strokePaint.setStyle(Paint.Style.STROKE);
            strokePaint.setStrokeWidth(strokeWidth);
            this.strokeColorStateList = strokeColorStateList;
        }
    }

    @Override
    protected void draw(Canvas canvas, RectF rectF, States states) {
        paint.setColor(colorStateList.getColorForState(states.getState(), Color.TRANSPARENT));
        draw(canvas, rectF, paint);
        if (strokeEnable) {
            strokePaint.setColor(strokeColorStateList.getColorForState(states.getState(), Color.TRANSPARENT));
            strokePaint.setStrokeWidth(strokeWidth);
            drawStroke(canvas, rectF, strokePaint, strokeWidth);
        }
    }

    @Override
    protected boolean onStateChange(States oldStates, States newStates) {
        return (newStates != null) && (oldStates == null || (oldStates.isEnable() != newStates.isEnable() || oldStates.isPressed() != newStates.isPressed()));
    }

    protected abstract void draw(Canvas canvas, RectF rectF, Paint paint);

    protected abstract void drawStroke(Canvas canvas, RectF rectF, Paint paint, float strokeWidth);

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        if (strokeEnable) {
            strokePaint.setAlpha(alpha);
        }
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        if (strokeEnable) {
            strokePaint.setColorFilter(colorFilter);
        }
    }

    @Override
    public boolean isStateful() {
        return colorStateList.isStateful() || (strokeEnable && strokeColorStateList.isStateful());
    }

    public void setPadding(Rect padding) {
        if (this.padding == null) {
            this.padding = new Rect(padding);
        } else {
            this.padding.set(padding);
        }
    }

    @Override
    public boolean getPadding(Rect padding) {
        if (this.padding == null) {
            return super.getPadding(padding);
        } else {
            padding.set(this.padding);
            return !padding.isEmpty();
        }
    }
}
