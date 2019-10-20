package com.android.pooyesh.activity;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.pooyesh.R;

/**
 * Created by Hossein Gheisary on 26/09/2019.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title, year, genre;

    public MyViewHolder(View view) {
        super(view);
        title = view.findViewById(R.id.title);
        genre = view.findViewById(R.id.genre);
        year = view.findViewById(R.id.year);
    }
}
