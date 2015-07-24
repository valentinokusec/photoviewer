package com.photoviewer.valentino.activities;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.photoviewer.valentino.objects.Location;
import com.photoviewer.valentino.photoviewer.R;

/**
 * Created by Tino on 22.7.2015..
 */
//this class is used to show more details about each location
public class Info extends ActionBarActivity {


    ImageView banner;
    //image1,image2,image3 represent three images at the bottom of the screen and when clicked we are transffered to the gallery activity
    ImageView image1;
    ImageView image2;
    ImageView image3;
    TextView lname;
    TextView ladress;
    TextView lmailadress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        //for the back button in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lname=(TextView)findViewById(R.id.name);
        ladress=(TextView)findViewById(R.id.adress);
        lmailadress=(TextView)findViewById(R.id.mailadress);
        banner=(ImageView)findViewById(R.id.banner);
        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        image3=(ImageView)findViewById(R.id.image3);



        banner.setImageResource(Location.getBanner());
        image1.setImageResource(Location.getImage1());
        image2.setImageResource(Location.getImage2());
        image3.setImageResource(Location.getImage3());
        lname.setText(Location.getName());
        ladress.setText(Location.getAdress());
        lmailadress.setText(Location.getMailadress());
        //onclicklisteners for each image
        image1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Gallery.class);

                startActivity(i);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Gallery.class);

                startActivity(i);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Gallery.class);

                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // respond to the action bar's back button
            case android.R.id.home:
                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
