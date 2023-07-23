package com.rdb.graphics;

import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public abstract class StateDrawable extends Drawable {

    private RectF rectF = new RectF();
    private States viewStates = new States();
    private States curViewStates = new States();

    @Override
    protected final boolean onStateChange(int[] state) {
        curViewStates.onStateChange(state);
        boolean invalidate = onStateChange(viewStates, curViewStates);
        States tempStates = viewStates;
        viewStates = curViewStates;
        curViewStates = tempStates;
        if (invalidate) {
            invalidateSelf();
        }
        return invalidate;
    }

    protected abstract void draw(Canvas canvas, RectF rectF, States states);

    protected abstract boolean onStateChange(States oldStates, States newStates);

    @Override
    public void invalidateSelf() {
        super.invalidateSelf();
    }

    @Override
    public final void draw(Canvas canvas) {
        draw(canvas, getRectF(), viewStates);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    private RectF getRectF() {
        Rect bounds = getBounds();
        rectF.set(bounds.left, bounds.top, bounds.right, bounds.bottom);
        return rectF;
    }
}
