package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CanvasActivity extends PaletteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Resources res = getResources();
        String[] color = res.getStringArray(R.array.string_array_color);
        setTitle("Canvas Activity");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        int position = getIntent().getIntExtra("position",0);
        TextView colorName = findViewById(R.id.colorName);
        colorName.setText(color[position]);
        colorName.setTextSize(48);

        if(color[position].equals("Negro") || color[position].equals("Black")){
            colorName.setTextColor(Color.WHITE);
        }else {
            colorName.setTextColor(Color.BLACK);
        }
        View secondB = findViewById(R.id.secondL);
        secondB.setBackgroundColor(Color.parseColor(coloren[position]));

    }
}
