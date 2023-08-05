package com.rdb.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DB on 2018/5/18.
 */

public class StateListDrawableBuilder {

    private final List<Item> items = new ArrayList<>();
    private StateListDrawable drawable;

    public StateListDrawableBuilder addItem(Drawable drawable, int... state) {
        items.add(new Item(drawable, state));
        return this;
    }

    public final StateListDrawable build() {
        if (drawable == null) {
            drawable = new StateListDrawable();
            for (int i = 0; i < items.size(); i++) {
                drawable.addState(items.get(i).state, items.get(i).drawable);
            }
        }
        return drawable;
    }

    private class Item {
        int[] state;
        Drawable drawable;

        public Item(Drawable drawable, int[] state) {
            this.drawable = drawable;
            this.state = state;
        }
    }
}
