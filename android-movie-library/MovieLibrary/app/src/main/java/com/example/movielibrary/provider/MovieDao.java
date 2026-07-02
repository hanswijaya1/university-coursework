package com.example.movielibrary.provider;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MovieDao {
    @Query("select * from movieTable")
    LiveData<List<Movie>> getAllItem();

    @Query("select * from movieTable where (movieTitle= :title) or (movieYear= :year) or (movieCost= :cost) or (movieCountry= :country) or (movieGenre= :genre) or (movieKeyword= :keyword)")
    LiveData<List<Movie>> search(String title, int year, int cost, String country, String genre, String keyword);


//    @Query("select * from movieTable where movieTitle=:title")
//    List<Movie> getSearchItem(String title);
    @Insert
    void addItem(Movie movie);

    @Query("delete from movieTable where movieYear= :year")
    void deleteByYear(int year);

//    @Query("delete from movieTable where movieCost< :cost")
//    void deleteByCost(int cost);

    @Query("delete FROM movieTable")
    void deleteAllItems();
}
