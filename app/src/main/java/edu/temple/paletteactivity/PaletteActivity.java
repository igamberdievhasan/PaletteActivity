package edu.temple.paletteactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaletteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ListView simpleList;

    public String [] color = {"Select","Red","Yellow","Blue","Green","Gray","Magenta","Cyan","Black","Maroon","Olive","Purple"};

    int size = color.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
        if(position <1) {

        }else{
            TextView colorNames = view.findViewById(R.id.textView);
            colorNames.setText(color[position]);
            colorNames.setTextColor(Color.parseColor(color[position]));
            colorNames.setBackgroundColor(Color.WHITE);

        }


        if(position > 0) {
            Intent canvasA = new Intent(this, CanvasActivity.class);
            canvasA.putExtra("position",position);
            startActivity(canvasA);
            //View secondB = findViewById(R.id.secondL);
            //secondB.setBackgroundColor(Color.parseColor(color[position]));
        }
        /*View background = findViewById(R.id.mainL);
        background.setBackgroundColor(Color.parseColor(color[position]));
*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        View background = findViewById(R.id.mainL);
        background.setBackgroundColor(Color.WHITE);

    }
}
