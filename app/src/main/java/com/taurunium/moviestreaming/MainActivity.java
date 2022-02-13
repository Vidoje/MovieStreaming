package com.taurunium.moviestreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private SliderPagerAdapter adapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.aquaman, "Aquaman"));
        lstSlides.add(new Slide(R.drawable.batman, "Batman"));
        lstSlides.add(new Slide(R.drawable.spiderman, "Spiderman"));

        viewPager = (ViewPager) findViewById(R.id.slider_pager);
        adapter = new SliderPagerAdapter(this, lstSlides);
        viewPager.setAdapter(adapter);

    }
}