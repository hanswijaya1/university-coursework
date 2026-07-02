package com.example.movielibrary.provider;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class MovieRepository {
    private MovieDao mMovieDao;
    private LiveData<List<Movie>> mAllMovies;

    MovieRepository(Application application) {
        MovieDatabase db = MovieDatabase.getDatabase(application);
        mMovieDao = db.movieDao();
        mAllMovies = mMovieDao.getAllItem();
    }

    LiveData<List<Movie>> getAllMovies() {
        return mAllMovies;
    }

    void insert(Movie mov) {
        MovieDatabase.databaseWriteExecutor.execute(() -> mMovieDao.addItem(mov));
    }

    void deleteAll(){
        MovieDatabase.databaseWriteExecutor.execute(()->{
            mMovieDao.deleteAllItems();
        });
    }
    void deleteByYear(Movie movie){
        MovieDatabase.databaseWriteExecutor.execute(() -> mMovieDao.deleteByYear(movie.getYear()));
    }

    LiveData<List<Movie>> search(String searchText){
        int searchTextInt;
        try{
            searchTextInt=Integer.parseInt(searchText);
        }catch (NumberFormatException e)
        {
            searchTextInt = -9999999;
        }
        LiveData<List<Movie>> returnList= mMovieDao.search(searchText,searchTextInt,searchTextInt,searchText,searchText,searchText);
        return returnList;
    }
}
