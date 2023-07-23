package com.rdb.graphics.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rdb.graphics.ColorCornerDrawable;
import com.rdb.graphics.color.SimpleColorStateList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView resultView = findViewById(R.id.resultView);
        ColorCornerDrawable drawable = new ColorCornerDrawable(
                SimpleColorStateList.instancePress(Color.RED, Color.TRANSPARENT, Color.TRANSPARENT), 12, 3, SimpleColorStateList.instance(Color.GREEN));
        resultView.setBackgroundDrawable(drawable);
    }

}
