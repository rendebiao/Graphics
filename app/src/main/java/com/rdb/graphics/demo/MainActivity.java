package com.rdb.graphics.demo;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rdb.graphics.State;
import com.rdb.graphics.color.ColorStateListBuilder;
import com.rdb.graphics.color.SimpleColorStateList;
import com.rdb.graphics.drawable.BitmapCornerDrawable;
import com.rdb.graphics.drawable.BitmapOvalDrawable;
import com.rdb.graphics.drawable.BitmapPolygonDrawable;
import com.rdb.graphics.drawable.ColorCornerDrawable;
import com.rdb.graphics.drawable.ColorOvalDrawable;
import com.rdb.graphics.drawable.ColorPolygonDrawable;
import com.rdb.graphics.drawable.ShapeUtils;
import com.rdb.graphics.drawable.StateListDrawableBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView button1 = findViewById(R.id.button1);
        TextView button2 = findViewById(R.id.button2);
        TextView button3 = findViewById(R.id.button3);
        TextView button4 = findViewById(R.id.button4);
        TextView button5 = findViewById(R.id.button5);
        TextView button6 = findViewById(R.id.button6);
        TextView button7 = findViewById(R.id.button7);
        TextView button8 = findViewById(R.id.button8);
        TextView button9 = findViewById(R.id.button9);
        TextView button10 = findViewById(R.id.button10);
        TextView button11 = findViewById(R.id.button11);
        TextView button12 = findViewById(R.id.button12);
        button1.setBackgroundDrawable(new ColorCornerDrawable(SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.BLUE), 12, 3, SimpleColorStateList.instance(Color.GREEN)));
        button2.setBackgroundDrawable(new ColorOvalDrawable(SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.BLUE), 3, SimpleColorStateList.instance(Color.GREEN)));
        button3.setBackgroundDrawable(new ColorPolygonDrawable(SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.BLUE), 3, SimpleColorStateList.instance(Color.GREEN), 5, 0));

        button4.setBackgroundDrawable(ShapeUtils.oval(Color.RED));
        button5.setBackgroundDrawable(ShapeUtils.oval(Color.RED, 3, Color.GREEN));
        button6.setBackgroundDrawable(ShapeUtils.rect(Color.RED));
        button7.setBackgroundDrawable(ShapeUtils.rect(Color.RED, 3, Color.GREEN));
        button8.setBackgroundDrawable(ShapeUtils.rect(Color.RED, 3, Color.GREEN, 4));
        StateListDrawable stateListDrawable = new StateListDrawableBuilder().addItem(ShapeUtils.oval(Color.RED), State.STATE_PRESSED).addItem(ShapeUtils.rect(Color.GREEN), State.STATE_NULL).build();
        button9.setBackgroundDrawable(stateListDrawable);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        button10.setBackgroundDrawable(new BitmapCornerDrawable(getResources(), bitmap, 12, 3, SimpleColorStateList.instance(Color.GREEN)));
        button11.setBackgroundDrawable(new BitmapOvalDrawable(getResources(), bitmap, 3, SimpleColorStateList.instance(Color.GREEN)));
        button12.setBackgroundDrawable(new BitmapPolygonDrawable(getResources(), bitmap, 3, SimpleColorStateList.instance(Color.GREEN), 5, 0));

        textView1.setTextColor(new SimpleColorStateList(Color.RED));
        textView2.setTextColor(new SimpleColorStateList(Color.RED, Color.GRAY));
        textView3.setTextColor(new SimpleColorStateList(Color.RED, Color.GRAY));
        textView3.setEnabled(false);
        textView4.setTextColor(new SimpleColorStateList(State.pressed.getAttr(), Color.RED, Color.GRAY, Color.GREEN));
        ColorStateList colorStateList = new ColorStateListBuilder().addItem(Color.RED, State.STATE_PRESSED).addItem(Color.BLUE, State.STATE_NULL).build();
        textView5.setTextColor(colorStateList);
    }

}
