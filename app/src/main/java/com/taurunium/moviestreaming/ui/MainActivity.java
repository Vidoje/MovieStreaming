package com.taurunium.moviestreaming.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.taurunium.moviestreaming.models.Movie;
import com.taurunium.moviestreaming.adapters.MovieAdapter;
import com.taurunium.moviestreaming.adapters.MovieItemClickListener;
import com.taurunium.moviestreaming.R;
import com.taurunium.moviestreaming.models.Slide;
import com.taurunium.moviestreaming.adapters.SliderPagerAdapter;
import com.taurunium.moviestreaming.utils.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private SliderPagerAdapter adapter;
    private TabLayout indicator;

    private ViewPager viewPager;
    private RecyclerView rvMovies, rvMoviesWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initSlider();
        initPopularMovies();
        initWeekMovies();
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.slider_pager);
        indicator = (TabLayout) findViewById(R.id.indicator);
        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);
        rvMoviesWeek = (RecyclerView) findViewById(R.id.rvMoviesWeek);
    }

    private void initSlider() {
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.aquaman, "Aquaman"));
        lstSlides.add(new Slide(R.drawable.batman, "Batman"));
        lstSlides.add(new Slide(R.drawable.spiderman, "Spiderman"));

        adapter = new SliderPagerAdapter(this, lstSlides);
        viewPager.setAdapter(adapter);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager(viewPager, true);
    }

    private void initPopularMovies() {
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(), this);
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initWeekMovies(){
        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getWeekMovies(), this);
        rvMoviesWeek.setAdapter(movieAdapter);
        rvMoviesWeek.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());

        //Animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView, "sharedName");

        startActivity(intent, options.toBundle());

    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < lstSlides.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}