package edu.temple.paletteactivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    private Context context;
    private String[] color;
    private LayoutInflater inflter;

    public ColorAdapter(Context context, String[] color) {
        this.context = context;
        this.color = color;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return color.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String [] coloren = {"Select","Red","Yellow","Blue","Green","Gray","Magenta","Cyan","Black","Maroon","Olive","Purple"};
        convertView = inflter.inflate(R.layout.list_view, null);

        TextView colorNames = convertView.findViewById(R.id.textView);
        if(position <1) {
            colorNames.setText(color[position]);
            colorNames.setHeight(0);

        }else{
            colorNames.setText(color[position]);
            colorNames.setBackgroundColor(Color.parseColor(coloren[position]));
        }

        if(coloren[position].equals("Black")){
            colorNames.setTextColor(Color.WHITE);
        }
        return convertView;
    }
}
