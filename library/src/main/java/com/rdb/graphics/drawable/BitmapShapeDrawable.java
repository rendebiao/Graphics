package com.rdb.graphics.drawable;


import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

import androidx.annotation.NonNull;

import com.rdb.graphics.States;

public abstract class BitmapShapeDrawable extends BitmapDrawable {

    private final Paint paint;
    private final boolean strokeEnable;
    private final States curStates = new States();
    private Paint strokePaint;
    private float strokeWidth;
    private States states = new States();
    private ColorStateList strokeColorStateList;

    public BitmapShapeDrawable(@NonNull Bitmap bitmap) {
        this(bitmap, 0, null);
    }

    public BitmapShapeDrawable(@NonNull Bitmap bitmap, float strokeWidth, ColorStateList strokeColorStateList) {
        super(bitmap);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
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
    protected final boolean onStateChange(int[] state) {
        curStates.onStateChange(state);
        if (!curStates.equals(states)) {
            boolean invalidate = onStateChange(states, curStates);
            this.states = curStates;
            if (invalidate) {
                invalidateSelf();
            }
        }
        return true;
    }

    @Override
    public final void draw(Canvas canvas) {
        RectF rectF = getRectF();
        int sc1 = canvas.saveLayer(0, 0, canvas.getWidth(), canvas.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        super.draw(canvas);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        int sc2 = canvas.saveLayer(rectF, paint, Canvas.ALL_SAVE_FLAG);
        paint.setXfermode(null);
        draw(canvas, rectF, paint);
        canvas.restoreToCount(sc2);
        canvas.restoreToCount(sc1);
        if (strokeEnable) {
            strokePaint.setColor(strokeColorStateList.getColorForState(states.getState(), Color.TRANSPARENT));
            strokePaint.setStrokeWidth(strokeWidth);
            drawStroke(canvas, rectF, strokePaint, strokeWidth);
        }
    }

    protected boolean onStateChange(States oldStates, States newStates) {
        return (newStates != null) && (oldStates == null || (oldStates.isEnable() != newStates.isEnable() || oldStates.isPressed() != newStates.isPressed()));
    }

    protected abstract void draw(Canvas canvas, RectF rectF, Paint paint);

    protected abstract void drawStroke(Canvas canvas, RectF rectF, Paint paint, float strokeWidth);

    @Override
    public boolean isStateful() {
        return (strokeEnable && strokeColorStateList.isStateful()) || super.isStateful();
    }

    private RectF getRectF() {
        Rect bounds = getBounds();
        return new RectF(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }
}
