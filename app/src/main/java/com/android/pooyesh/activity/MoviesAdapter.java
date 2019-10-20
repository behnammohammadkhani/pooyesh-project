package com.android.pooyesh.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.recyclerview.widget.RecyclerView;

import com.android.pooyesh.R;
import com.android.pooyesh.models.Movie;
import com.android.pooyesh.models.onTouch;

import java.util.List;

/**
 * Created by Hossein Gheisary on 26/09/2019.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Movie> moviesList;
    private Context context;
    private onTouch onTouchListener;

    public MoviesAdapter(List<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.animation);

        holder.itemView.setAnimation(animAnticipateOvershoot);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (onTouchListener != null) {

                    onTouchListener.onTouchListener(position);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setOnTouch(onTouch listener) {

       this.onTouchListener =listener;


    }
}