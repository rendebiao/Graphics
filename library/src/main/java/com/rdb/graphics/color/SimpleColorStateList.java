package com.rdb.graphics.color;

import android.content.res.ColorStateList;

import androidx.annotation.ColorInt;

import com.rdb.graphics.State;

/**
 * Created by DB on 2019/3/20.
 */

public class SimpleColorStateList extends ColorStateList {


    public SimpleColorStateList(@ColorInt int color) {
        super(State.STATES_NULL, new int[]{color});
    }

    public SimpleColorStateList(@ColorInt int color, @ColorInt int disableColor) {
        super(State.STATES_DISABLE_OTHER, new int[]{disableColor, color});
    }

    public SimpleColorStateList(int state, @ColorInt int stateColor, @ColorInt int disableColor, @ColorInt int otherColor) {
        super(new int[][]{State.STATE_DISABLE, new int[]{state}, State.STATE_NULL}, new int[]{disableColor, stateColor, otherColor});
    }


    public static SimpleColorStateList instance(int color) {
        return new SimpleColorStateList(color);
    }

    public static SimpleColorStateList instance(@ColorInt int color, @ColorInt int disableColor) {
        return new SimpleColorStateList(color, disableColor);
    }

    public static SimpleColorStateList instancePress(int pressedColor, int normalColor) {
        return new SimpleColorStateList(State.pressed.getValue(true), pressedColor, normalColor, normalColor);
    }

    public static SimpleColorStateList instancePress(int pressedColor, int disableColor, int normalColor) {
        return new SimpleColorStateList(State.pressed.getValue(true), pressedColor, disableColor, normalColor);
    }

    public static SimpleColorStateList instanceFocus(int focusColor, int disableColor, int normalColor) {
        return new SimpleColorStateList(State.focused.getValue(true), focusColor, disableColor, normalColor);
    }
}
