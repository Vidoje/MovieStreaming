package com.taurunium.moviestreaming.adapters;

import android.widget.ImageView;

import com.taurunium.moviestreaming.models.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView movieImageView);
}
