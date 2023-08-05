package com.rdb.graphics.demo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rdb.graphics.State;
import com.rdb.graphics.color.ColorStateListBuilder;
import com.rdb.graphics.color.SimpleColorStateList;
import com.rdb.graphics.drawable.ColorCornerDrawable;
import com.rdb.graphics.drawable.ColorOvalDrawable;
import com.rdb.graphics.drawable.ColorPolygonDrawable;
import com.rdb.graphics.drawable.StateListDrawableBuilder;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView testView1 = findViewById(R.id.testView1);
        TextView testView2 = findViewById(R.id.testView2);
        TextView testView3 = findViewById(R.id.testView3);
        ColorCornerDrawable drawable1 = new ColorCornerDrawable(SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.BLUE), 12, 3, SimpleColorStateList.instance(Color.GREEN));
        testView1.setBackgroundDrawable(drawable1);

        ColorOvalDrawable drawable2 = new ColorOvalDrawable(SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.BLUE), 3, SimpleColorStateList.instance(Color.GREEN));
        testView2.setBackgroundDrawable(drawable2);

        ColorPolygonDrawable drawable3 = new ColorPolygonDrawable(SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.BLUE), 3, SimpleColorStateList.instance(Color.GREEN), 5, 0);
        testView3.setBackgroundDrawable(drawable3);

        SimpleColorStateList simpleColorStateList1 = new SimpleColorStateList(Color.RED);
        SimpleColorStateList simpleColorStateList2 = new SimpleColorStateList(Color.RED, Color.GRAY);
        SimpleColorStateList simpleColorStateList3 = new SimpleColorStateList(State.checked.getAttr(), Color.RED, Color.GRAY, Color.GREEN);
        ColorStateList colorStateList = new ColorStateListBuilder().addItem(Color.RED, State.checked.getAttr()).addItem(Color.BLUE, State.pressed.getAttr()).build();

        StateListDrawable stateListDrawable = new StateListDrawableBuilder().addItem(drawable1, State.checked.getAttr()).addItem(drawable2, State.pressed.getAttr()).build();
    }

}
