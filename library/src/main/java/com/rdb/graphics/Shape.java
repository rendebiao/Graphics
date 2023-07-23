package com.rdb.graphics;

import android.graphics.drawable.GradientDrawable;

public class Shape {

    public static GradientDrawable oval(int solidColor) {
        return oval(solidColor, 0, 0);
    }

    public static GradientDrawable oval(int solidColor, int strokeWidth, int strokeColor) {
        return shape(solidColor, strokeWidth, strokeColor, 0, GradientDrawable.OVAL);
    }

    public static GradientDrawable rect(int solidColor) {
        return rect(solidColor, 0, 0);
    }

    public static GradientDrawable rect(int solidColor, float cornerRadius) {
        return rect(solidColor, 0, 0, cornerRadius);
    }

    public static GradientDrawable rect(int solidColor, int strokeWidth, int strokeColor) {
        return rect(solidColor, strokeWidth, strokeColor, 0);
    }

    public static GradientDrawable rect(int solidColor, int strokeWidth, int strokeColor, float cornerRadius) {
        return shape(solidColor, strokeWidth, strokeColor, cornerRadius, GradientDrawable.RECTANGLE);
    }

    private static GradientDrawable shape(int solidColor, int strokeWidth, int strokeColor, float cornerRadius, int shape) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(shape);
        drawable.setColor(solidColor);
        if (strokeWidth > 0) {
            drawable.setStroke(strokeWidth, strokeColor);
        }
        if (cornerRadius > 0) {
            drawable.setCornerRadius(cornerRadius);
        }
        return drawable;
    }
}
