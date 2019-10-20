package com.android.pooyesh.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.pooyesh.models.Movie;
import com.android.pooyesh.MyAPP;
import com.android.pooyesh.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    public List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    public MoviesAdapter mAdapter;


    @Inject
    mainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupView();

        MyAPP.getComponent().InjectMainViewModel(this);

        mainViewModel.DataResponse.observe(this, movies -> {
            movieList.addAll(movies);
            mAdapter.notifyDataSetChanged();
        });

        mainViewModel.GetMovieData();

    }

    private void SetupView() {
        recyclerView = findViewById(R.id.mainListRecyclerView);

        mAdapter = new MoviesAdapter(movieList, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnTouch(position ->
                Toast.makeText(MainActivity.this, "item: " + position, Toast.LENGTH_SHORT).show());
    }


}
