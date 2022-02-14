package com.taurunium.moviestreaming.ui;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.taurunium.moviestreaming.R;
import com.taurunium.moviestreaming.adapters.CastAdapter;
import com.taurunium.moviestreaming.models.Cast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView ivMovieDetail, ivMovieCoverImage;
    private TextView tvTitle, tvDescription;
    private FloatingActionButton fabPlay;
    private RecyclerView rvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initViews();
        initRvCast();
    }

    private void initViews() {
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = (int) getIntent().getExtras().get("imgURL");
        int imageCoverResourceId = (int) getIntent().getExtras().get("imgCover");

        ivMovieDetail = (ImageView) findViewById(R.id.ivMovieDetail);
        ivMovieDetail.setImageResource(imageResourceId);

        ivMovieCoverImage = (ImageView) findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imageCoverResourceId).into(ivMovieCoverImage);
        ivMovieCoverImage.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

        tvTitle = (TextView) findViewById(R.id.detail_movie_title);
        tvDescription = (TextView) findViewById(R.id.detail_movie_description);

        tvTitle.setText(movieTitle);

        fabPlay = (FloatingActionButton) findViewById(R.id.fabPlay);
        fabPlay.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

        rvCast = (RecyclerView) findViewById(R.id.rvCast);
    }

    private void initRvCast() {
        List<Cast> mData = new ArrayList<>();
        mData.add(new Cast("Glupi Glumac", R.drawable.donald_duck));
        mData.add(new Cast("Glupi Glumac", R.drawable.donald_duck));
        mData.add(new Cast("Glupi Glumac", R.drawable.donald_duck));

        castAdapter = new CastAdapter(this, mData);
        rvCast.setAdapter(castAdapter);
        rvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }


}