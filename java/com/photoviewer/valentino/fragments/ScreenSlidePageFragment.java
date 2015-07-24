package com.photoviewer.valentino.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.photoviewer.valentino.objects.Location;
import com.photoviewer.valentino.photoviewer.R;
import com.photoviewer.valentino.imageView.TouchImageView;
//fragment that contains imageview
public class ScreenSlidePageFragment extends Fragment {
// for the image view we are using custom class touchimageview for the pinch and zoom effect
    TouchImageView image;

    public static final String ARG_PAGE = "page";
    //create() is a method that is called every time user swipes
    //every time when a users swipes the fragment is recreated and every time page number is passed, and based on page number different image is shown
    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.gallery, container, false);
        image = (TouchImageView) rootView.findViewById(R.id.imageView);
        //ARG_PAGE countains the number of the page user is currently viewing and based on that we set the image source
        switch (getArguments().getInt(ARG_PAGE)){
            case 0:  image.setImageResource(Location.getImage11());
                break;
            case 1:  image.setImageResource(Location.getImage12());
                break;
            case 2:  image.setImageResource(Location.getImage13());
                break;
            case 3:  image.setImageResource(Location.getImage14());
                break;
            case 4:  image.setImageResource(Location.getImage15());
                break;

        }



        return rootView;
    }
}