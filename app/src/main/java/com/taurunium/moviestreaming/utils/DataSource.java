package com.taurunium.moviestreaming.utils;

import com.taurunium.moviestreaming.R;
import com.taurunium.moviestreaming.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Movie> getPopularMovies(){
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Mickey Mouse", R.drawable.mickey_mouse, R.drawable.batman));
        lstMovies.add(new Movie("Bugs Bunny", R.drawable.dusko_dugousko, R.drawable.batman));
        lstMovies.add(new Movie("Ninja Turtles", R.drawable.nindza_kornjace, R.drawable.batman));
        lstMovies.add(new Movie("Donald Duck", R.drawable.donald_duck, R.drawable.batman));
        lstMovies.add(new Movie("The Smurfs", R.drawable.strumpfovi, R.drawable.batman));

        return lstMovies;
    }

    public static List<Movie> getWeekMovies(){
        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Donald Duck", R.drawable.donald_duck, R.drawable.batman));
        lstMovies.add(new Movie("The Smurfs", R.drawable.strumpfovi, R.drawable.batman));
        lstMovies.add(new Movie("Ninja Turtles", R.drawable.nindza_kornjace, R.drawable.batman));
        lstMovies.add(new Movie("Mickey Mouse", R.drawable.mickey_mouse, R.drawable.batman));
        lstMovies.add(new Movie("Bugs Bunny", R.drawable.dusko_dugousko, R.drawable.batman));

        return lstMovies;
    }
}
