package com.rdb.graphics.color;

import android.content.res.ColorStateList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DB on 2018/5/18.
 */

public class ColorStateListBuilder {

    private ColorStateList list;
    private List<Item> items = new ArrayList<>();

    public ColorStateListBuilder addItem(int color, int... state) {
        items.add(new Item(color, state));
        return this;
    }

    public final ColorStateList build() {
        if (list == null) {
            int[] colors = new int[items.size()];
            int[][] states = new int[items.size()][];
            for (int i = 0; i < items.size(); i++) {
                colors[i] = items.get(i).color;
                states[i] = items.get(i).state;
            }
            list = new ColorStateList(states, colors);
        }
        return list;
    }

    private class Item {
        int color;
        int[] state;

        public Item(int color, int[] state) {
            this.color = color;
            this.state = state;
        }
    }
}
