package com.example.movielibrary.provider;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository mRepository;
    private LiveData<List<Movie>> mAllMovies;


    public MovieViewModel(@NonNull Application application) {
        super(application);
        mRepository = new MovieRepository(application);
        mAllMovies = mRepository.getAllMovies();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return mAllMovies;
    }
    public void insert(Movie movie) {
        mRepository.insert(movie);
    }
    public void deleteAll(){
        mRepository.deleteAll();
    }
    public void deleteByYear(Movie movie){mRepository.deleteByYear(movie);}
    public LiveData<List<Movie>> search(String searchText){
        LiveData<List<Movie>> returnList = mRepository.search(searchText);
        return returnList;
    }
}
