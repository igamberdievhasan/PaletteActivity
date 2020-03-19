package edu.temple.paletteactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaletteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    public String [] coloren = {"Select","Red","Yellow","Blue","Green","Gray","Magenta","Cyan","Black","Maroon","Olive","Purple"};


    //int l = color.length;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Resources res = getResources();
        String[] color = res.getStringArray(R.array.string_array_color);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ColorAdapter customAdapter = new ColorAdapter(getApplicationContext(),color);
        spinner.setAdapter(customAdapter);

        View background = findViewById(R.id.mainL);
        background.setBackgroundColor(Color.WHITE);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Resources res = getResources();
        String[] color = res.getStringArray(R.array.string_array_color);
        if(position <1) {

        }else{
            TextView colorNames = view.findViewById(R.id.textView);
            colorNames.setText(color[position]);
            colorNames.setTextColor(Color.parseColor(coloren[position]));
            colorNames.setBackgroundColor(Color.WHITE);

        }


        if(position > 0) {
            Intent canvasA = new Intent(this, CanvasActivity.class);
            canvasA.putExtra("position",position);
            startActivity(canvasA);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        View background = findViewById(R.id.mainL);
        background.setBackgroundColor(Color.WHITE);

    }
}
