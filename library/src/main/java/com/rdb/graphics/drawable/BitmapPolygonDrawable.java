package com.rdb.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import androidx.annotation.NonNull;

public class BitmapPolygonDrawable extends BitmapShapeDrawable {
    private float radius;
    private float centerX;
    private float centerY;
    private float[] degrees;
    private Path drawPath;

    public BitmapPolygonDrawable(Resources resources, @NonNull Bitmap bitmap, int sideCount, float startDegree) {
        this(resources, bitmap, 0, null, sideCount, startDegree);
    }

    public BitmapPolygonDrawable(Resources resources, @NonNull Bitmap bitmap, float strokeWidth, ColorStateList strokeColorStateList, int sideCount, float startDegree) {
        super(resources, bitmap, strokeWidth, strokeColorStateList);
        init(sideCount, startDegree);
    }

    private static float getCirclePointX(float centerX, float radius, float degree) {
        return (float) (centerX + radius * Math.cos(degree * Math.PI / 180));
    }

    private static float getCirclePointY(float centerY, float radius, float degree) {
        return (float) (centerY + radius * Math.sin(degree * Math.PI / 180));
    }

    private void init(int sideCount, float startDegree) {
        drawPath = new Path();
        degrees = new float[sideCount];
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = 360 * i / sideCount + startDegree;
        }
    }

    @Override
    protected void draw(Canvas canvas, RectF rectF, Paint paint) {
        centerX = rectF.centerX();
        centerY = rectF.centerY();
        radius = Math.min(rectF.width(), rectF.height()) / 2;
        for (int i = 0; i < degrees.length; i++) {
            if (i == 0) {
                drawPath.moveTo(getCirclePointX(centerX, radius, degrees[i]), getCirclePointY(centerY, radius, degrees[i]));
            } else {
                drawPath.lineTo(getCirclePointX(centerX, radius, degrees[i]), getCirclePointY(centerY, radius, degrees[i]));
            }
        }
        drawPath.close();
        canvas.drawPath(drawPath, paint);
        drawPath.reset();
    }

    @Override
    protected void drawStroke(Canvas canvas, RectF rectF, Paint paint, float strokeWidth) {
        centerX = rectF.centerX();
        centerY = rectF.centerY();
        radius = (Math.min(rectF.width(), rectF.height()) - strokeWidth) / 2;
        for (int i = 0; i < degrees.length; i++) {
            if (i == 0) {
                drawPath.moveTo(getCirclePointX(centerX, radius, degrees[i]), getCirclePointY(centerY, radius, degrees[i]));
            } else {
                drawPath.lineTo(getCirclePointX(centerX, radius, degrees[i]), getCirclePointY(centerY, radius, degrees[i]));
            }
        }
        drawPath.close();
        canvas.drawPath(drawPath, paint);
        drawPath.reset();
    }
}
