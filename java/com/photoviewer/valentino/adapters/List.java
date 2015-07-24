package com.photoviewer.valentino.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.photoviewer.valentino.photoviewer.R;

/**
 * Created by Tino on 21.7.2015..
 */
//adapter for the list
public class List extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] name;
    private final String[] adress;
    private final String[] mailadress;
    private final Integer[] imageId;
    //constructor that needs to get all the data to populate each list row
    public List(Activity context,
                      String[] name,String[] adress,String[] mailadress, Integer[] imageId) {
        super(context, R.layout.list_row, name);
        this.context = context;
        this.name = name;
        this.adress = adress;
        this.mailadress = mailadress;
        this.imageId = imageId;
    }
    //here we populate every row of the list with the proper data
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_row, null, true);
        TextView name = (TextView) rowView.findViewById(R.id.txt);
        TextView adress = (TextView) rowView.findViewById(R.id.txt1);
        TextView mailadress = (TextView) rowView.findViewById(R.id.txt2);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        name.setText(this.name[position]);
        adress.setText(this.adress[position]);
        mailadress.setText(this.mailadress[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
