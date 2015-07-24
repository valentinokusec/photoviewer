package com.photoviewer.valentino.activities;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;


import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;


import com.photoviewer.valentino.fragments.ScreenSlidePageFragment;
import com.photoviewer.valentino.photoviewer.R;

/**
 * Created by Tino on 23.7.2015..
 */
//our gallery activity, that has a viewpager, every page holds one image and each image has a pinch to zoom effect
public class Gallery extends ActionBarActivity {

    //number of max pages in the view pager
    private static final int NUM_PAGES = 5;


    private ViewPager mPager;

    /**
     * the pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentholder);
        // to show the back button in the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            // When changing pages, reset the action bar actions since they are dependent
            // on which page is currently active. An alternative approach is to have each
            // fragment expose actions itself (rather than the activity exposing actions),
            // but for simplicity, the activity provides the actions in this sample.
            invalidateOptionsMenu();
        }
    });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent i = new Intent(getApplicationContext(), Info.class);

                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
// our class for custom adapter
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //every time user slides a we are calling create() from ScreenSlidePageFragment class,
        // reason why we are calling a method that creates a fragment insted of creating a new one is so that we can pass a variable
        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
