package com.photoviewer.valentino.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.photoviewer.valentino.adapters.List;
import com.photoviewer.valentino.objects.Location;
import com.photoviewer.valentino.photoviewer.R;

//main activity that simple holds one list, the list contains locations, and the items on each list are a image name adresss and mail adress
public class MainActivity extends ActionBarActivity {
    ListView list;
    //here we initalize var for that data of each location

    //name of the location
    String[] name = {
            "Al acarte",
            "Aquamarin",
            "Barfly",
            "Emporio",
            "Mabis",
            "Mea Culpa",
            "Medonja",
            "MyWay",
            "Office",
            "Ritz"
    } ;

    //adress of the location
    String[] adress = {
            "Julija Merli�a 9",
            "Ul. Ljudevita Gaja 1",
            "Ul. Vatroslava Lisinskog 3",
            "Trg Kralja Tomislava 4",
            "Pavlinska 3",
            "Ivana Padovca 1",
            "Kapucinski trg 2",
            "Trg Miljenka Stan�i�a 1",
            "Trg Kralja Tomislava 2",
            "Franjeva�ki trgu 4"
    } ;

    //mail adress of the location
    String[] mailadress = {
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din",
            "42000, Vara�din"
    } ;

    // array that holds images for the list
    Integer[] imageId = {
            R.drawable.alacarte1,
            R.drawable.aqua1,
            R.drawable.barfly1,
            R.drawable.emporio1,
            R.drawable.mabis1,
            R.drawable.mea1,
            R.drawable.medonja1,
            R.drawable.myway1,
            R.drawable.office1,
            R.drawable.ritz1
    };

    //banner image for the info class
    Integer[] bannerid = {
            R.drawable.alacarte5,
            R.drawable.aqua5,
            R.drawable.barfly5,
            R.drawable.emporio5,
            R.drawable.mabis5,
            R.drawable.mea5,
            R.drawable.medonja5,
            R.drawable.myway5,
            R.drawable.office5,
            R.drawable.ritz5
    };

    //imageide1, imageid2, imageid3 are used for the images in the info class
    Integer[] imageid1 = {
            R.drawable.alacarte2,
            R.drawable.aqua2,
            R.drawable.barfly2,
            R.drawable.emporio2,
            R.drawable.mabis2,
            R.drawable.mea2,
            R.drawable.medonja2,
            R.drawable.myway2,
            R.drawable.office2,
            R.drawable.ritz2
    };
    Integer[] imageid2 = {
            R.drawable.alacarte3,
            R.drawable.aqua3,
            R.drawable.barfly3,
            R.drawable.emporio3,
            R.drawable.mabis3,
            R.drawable.mea3,
            R.drawable.medonja3,
            R.drawable.myway3,
            R.drawable.office3,
            R.drawable.ritz3
    };
    Integer[] imageid3 = {
            R.drawable.alacarte4,
            R.drawable.aqua4,
            R.drawable.barfly4,
            R.drawable.emporio4,
            R.drawable.mabis4,
            R.drawable.mea4,
            R.drawable.medonja4,
            R.drawable.myway4,
            R.drawable.office4,
            R.drawable.ritz4
    };
    //imageid11,imageid12,imageid13,imageid14,imageid15 hold the images for the gallery class
    Integer[] imageid11 = {
            R.drawable.alacarte11,
            R.drawable.aqua1,
            R.drawable.barfly1,
            R.drawable.emporio1,
            R.drawable.mabis1,
            R.drawable.mea1,
            R.drawable.medonja1,
            R.drawable.myway1,
            R.drawable.office1,
            R.drawable.ritz1
    };
    Integer[] imageid12 = {
            R.drawable.alacarte12,
            R.drawable.aqua1,
            R.drawable.barfly1,
            R.drawable.emporio1,
            R.drawable.mabis1,
            R.drawable.mea1,
            R.drawable.medonja1,
            R.drawable.myway1,
            R.drawable.office1,
            R.drawable.ritz1
    };
    Integer[] imageid13 = {
            R.drawable.alacarte13,
            R.drawable.aqua1,
            R.drawable.barfly1,
            R.drawable.emporio1,
            R.drawable.mabis1,
            R.drawable.mea1,
            R.drawable.medonja1,
            R.drawable.myway1,
            R.drawable.office1,
            R.drawable.ritz1
    };
    Integer[] imageid14 = {
            R.drawable.alacarte14,
            R.drawable.aqua1,
            R.drawable.barfly1,
            R.drawable.emporio1,
            R.drawable.mabis1,
            R.drawable.mea1,
            R.drawable.medonja1,
            R.drawable.myway1,
            R.drawable.office1,
            R.drawable.ritz1
    };
    Integer[] imageid15 = {
            R.drawable.alacarte15,
            R.drawable.aqua1,
            R.drawable.barfly1,
            R.drawable.emporio1,
            R.drawable.mabis1,
            R.drawable.mea1,
            R.drawable.medonja1,
            R.drawable.myway1,
            R.drawable.office1,
            R.drawable.ritz1
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //here we initialize the list, populate it with data and set our custom adapter
        List adapter = new List(MainActivity.this, name,adress,mailadress, imageId);
        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // we populate the Location object with the proper data
                Location.setName(name[position]);
                Location.setAdress(adress[position]);
                Location.setMailadress(mailadress[position]);
                Location.setBanner(bannerid[position]);
                Location.setImage1(imageid1[position]);
                Location.setImage2(imageid2[position]);
                Location.setImage3(imageid3[position]);
                Location.setImage11(imageid11[position]);
                Location.setImage12(imageid12[position]);
                Location.setImage13(imageid13[position]);
                Location.setImage14(imageid14[position]);
                Location.setImage15(imageid15[position]);
                // onlick on list item we are transffered to the info class
                Intent i = new Intent(getApplicationContext(), Info.class);

                startActivity(i);
        }
        });
    }




}
