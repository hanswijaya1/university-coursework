package com.example.movielibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.movielibrary.provider.Movie;
import com.example.movielibrary.provider.MovieViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    public static MovieViewModel mMovieViewModel;

//    Gson gson = new Gson();
//    ArrayList<Movie> movieData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        SharedPreferences sP = getSharedPreferences("cardMovieDetails",0);
//        String dataString = sP.getString("movieDetailsCard","");
//        Type type = new TypeToken<ArrayList<Movie>>() {}.getType();
//        movieData=gson.fromJson(dataString,type);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        mMovieViewModel=new ViewModelProvider(this).get(MovieViewModel.class);
        mMovieViewModel.getAllMovies().observe(this, newData -> {
            adapter.setData(newData);
            adapter.notifyDataSetChanged();
        });

        FloatingActionButton goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

    }
    public void goBack(View v){
        finish();
    }

    public void search(View v){
        EditText keyword = findViewById(R.id.search);
        mMovieViewModel.search(keyword.getText().toString()).observe(this, newData ->{
            adapter.setData(newData);
            adapter.notifyDataSetChanged();
        });
    }

    public void reset(View v) {
        mMovieViewModel.getAllMovies().observe(this, newData -> {
            adapter.setData(newData);
            adapter.notifyDataSetChanged();
        });
    }
}