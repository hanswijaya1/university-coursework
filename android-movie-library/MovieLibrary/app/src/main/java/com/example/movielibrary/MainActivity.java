package com.example.movielibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.gesture.Gesture;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movielibrary.provider.Movie;
import com.example.movielibrary.provider.MovieViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {

    EditText movieNames;
    EditText years;
    EditText countryNames;
    EditText genres;
    EditText costs;
    EditText keywordss;

//    Gson gson = new Gson();
    ArrayList<String> movieList = new ArrayList<>();
    ArrayAdapter myAdapter;
    DrawerLayout drawerLayout;
//    ArrayList<Movie> movies = new ArrayList<>();
    MovieViewModel mMovieViewModel;
    RecyclerAdapter adapter;
    DatabaseReference myRef;
    View frameLayout;
    View constraintView;
    GestureDetector gestureDetector;
    ScaleGestureDetector scaleGestureDetector;

    int x_down;
    int y_down;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);

        registerReceiver(movieDetailsReceiver, new IntentFilter(SMSReceiver.filter));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView= findViewById(R.id.listView);
        myAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, movieList);
        listView.setAdapter(myAdapter);

        drawerLayout= findViewById(R.id.dl);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView myNavigationView = findViewById(R.id.nv);
        myNavigationView.setNavigationItemSelectedListener(new NavigationListener());

        mMovieViewModel=new ViewModelProvider(this).get(MovieViewModel.class);
        mMovieViewModel.getAllMovies().observe(this, newData -> {
            adapter.setData(newData);
            adapter.notifyDataSetChanged();
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Movies");

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMovie(view);
            }
        });
        adapter = new RecyclerAdapter();

        gestureDetector = new GestureDetector(this, new MyGestureDetector());
        scaleGestureDetector = new ScaleGestureDetector(this, new MyScaleGestureDetector());
        constraintView = findViewById(R.id.constraint_view);
        frameLayout = findViewById(R.id.frame_layout);
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
//                int action = motionEvent.getActionMasked();
//                switch (action){
//                    case MotionEvent.ACTION_DOWN:
//                        x_down = (int) motionEvent.getX();
//                        y_down = (int) motionEvent.getY();
//                        if (x_down<=100 && y_down<=100){
//                            decreaseCost(view,50);
//                        }
//                        else if (x_down>=1000 & y_down<=100){
//                            increaseCost(view,50);
//                        }
//                        return true;
//
//                    case MotionEvent.ACTION_MOVE:
//                        int xValue = (int) motionEvent.getX();
//                        int yValue = (int) motionEvent.getY();
//                        if (xValue<=100 && yValue <=100){
//                            decreaseCost(view,50);
//                        }
//                        else if (xValue>=1000 && yValue<=100){
//                            increaseCost(view,50);
//                        }
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        if (Math.abs(y_down-(int)motionEvent.getY())<40){
//                            //check to see if the user is only doing it horizontally and not diagonally
//                            if (x_down-(int) motionEvent.getX()<=-40){
//                                //left to right
//                                addMovie(view);
//                            }
//                            //Leave room for right to left movement for extra lab task
//                    } else if(Math.abs(x_down-(int)motionEvent.getX())<40){
//                            //check whether the user is only doing it vertically and not diagonally
//                            if (y_down-(int)motionEvent.getY()<=-40){
//                                //top to bottom, top left is 0,0
//                                clearAll(view);
//                            }
//                        }
//                        return true;
//                }
                return true;
            }
        });
//        constraintView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                scaleGestureDetector.onTouchEvent(motionEvent);
//                return true;
//            }
//        });
    }


    public void addMovie(View view){
        EditText movieName = findViewById(R.id.editMovieName);
        Toast myMessage = Toast.makeText(this,"Movie - "+movieName.getText().toString()+"- has been added",Toast.LENGTH_SHORT);
        myMessage.show();
        EditText year = findViewById(R.id.editYear);
        EditText countryName = findViewById(R.id.editCountry);
        EditText genre = findViewById(R.id.editGenre);
        EditText cost = findViewById(R.id.editCost);
        EditText keywords = findViewById(R.id.editKeywords);

        String title = movieName.getText().toString();
        String yearReleased = year.getText().toString();
        if (yearReleased==null || yearReleased.equals("")){
            yearReleased="0";
        }
        String country = countryName.getText().toString();
        String genres = genre.getText().toString();
        String costs= cost.getText().toString();
        if (costs==null || costs.equals("")){
            costs="0";
        }
        String keyword = keywords.getText().toString();

        SharedPreferences movieAttributes = getSharedPreferences("saveLastMovie",0);
        SharedPreferences.Editor myEditor = movieAttributes.edit();
        myEditor.putString("movieName",title);
        myEditor.putString("year",yearReleased);
        myEditor.putString("countryName",country);
        myEditor.putString("genre",genres);
        myEditor.putString("cost",costs);
        myEditor.putString("keywords",keyword);
        myEditor.commit();

        movieList.add(title+" | "+yearReleased);
        myAdapter.notifyDataSetChanged();
//        movies.add(new Movie(title,yearReleased,country,genres,costs,keyword));
        Movie newMovie = new Movie(title,Integer.parseInt(yearReleased),country,genres,Integer.parseInt(costs),keyword);
        mMovieViewModel.insert(newMovie);
        myRef.push().setValue(newMovie);

    }

    public void decreaseCost(View v,int cost){
        EditText costText = findViewById(R.id.editCost);
        int costValue;
        String text = costText.getText().toString();
        if (text==null || text.equals("")){
            costValue=0;
        }
        else {
            costValue = Integer.parseInt(text);
        }
        if (costValue<cost){
            costText.setText("0");
        }
        else{
            costText.setText((costValue-cost)+"");
        }
    }

    public void increaseCost(View v, int cost){
        EditText costText = findViewById(R.id.editCost);
        int costValue;
        String text = costText.getText().toString();
        if (text==null || text.equals("")){
            costValue=0;
        }
        else {
            costValue = Integer.parseInt(text);
        }
        costText.setText((costValue+cost)+"");
    }

    public void changeYear(View v, int changeYearBy){
        int yearValue;
        EditText yearText = findViewById(R.id.editYear);
        String text = yearText.getText().toString();
        if (text == null || text.equals("")){
            yearValue=0;
        }
        else{
            yearValue = Integer.parseInt(text);
        }
        yearText.setText((yearValue+changeYearBy)+"");
    }

//    public void doubleCost (View view){
//        EditText cost = findViewById(R.id.editCost);
//        int timesTwo=Integer.parseInt(cost.getText().toString())*2;
//        //can use double with parseDouble
//        String timeTwo= timesTwo+"";
//        cost.setText(timeTwo);
//    }

    public void clearAll (View view){
        EditText movieName = findViewById(R.id.editMovieName);
        EditText year = findViewById(R.id.editYear);
        EditText countryName = findViewById(R.id.editCountry);
        EditText genre = findViewById(R.id.editGenre);
        EditText cost = findViewById(R.id.editCost);
        EditText keywords = findViewById(R.id.editKeywords);
        movieName.setText("");
        year.setText("");
        countryName.setText("");
        genre.setText("");
        cost.setText("");
        keywords.setText("");
    }

//    public void clearSP(View view){
//        SharedPreferences movieAttributes = getSharedPreferences("saveLastMovie",0);
//        SharedPreferences.Editor myEditor = movieAttributes.edit();
//        myEditor.clear();
//        myEditor.commit();
//    }

//    public void DoubleLoad (View view){
//        SharedPreferences movieAttributes = getSharedPreferences("saveLastMovie",0);
//        int cost = Integer.parseInt(movieAttributes.getString("cost","0"))*2;
//        String putText = cost+"";
//        SharedPreferences.Editor myEditor = movieAttributes.edit();
//        myEditor.putString("cost", putText);
//        myEditor.commit();
//        EditText costs = findViewById(R.id.editCost);
//        costs.setText(movieAttributes.getString("cost",""));
//    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText movieName = findViewById(R.id.editMovieName);
        EditText year = findViewById(R.id.editYear);
        EditText countryName = findViewById(R.id.editCountry);
        EditText genre = findViewById(R.id.editGenre);
        EditText cost = findViewById(R.id.editCost);
        EditText keywords = findViewById(R.id.editKeywords);

        SharedPreferences movieAttributes = getSharedPreferences("saveLastMovie",0);
        String title = movieAttributes.getString("movieName","");
        String yearReleased = movieAttributes.getString("year","");
        String country = movieAttributes.getString("countryName","");
        String genres = movieAttributes.getString("genre","");
        String costs = movieAttributes.getString("cost","");
        String keyword = movieAttributes.getString("keywords","");

        movieName.setText(title);
        year.setText(yearReleased);
        countryName.setText(country);
        genre.setText(genres);
        cost.setText(costs);
        keywords.setText(keyword);
    }

 /*   @Override
    protected void onResume() {
        super.onResume();
    }*/

//    @Override
//    protected void onStop() {
//        super.onStop();
//    }

 /*   @Override
    protected void onDestroy() {
        super.onDestroy();
    }*/

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        EditText genre = findViewById(R.id.editGenre);
        genre.setText(genre.getText().toString().toLowerCase());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText titleName = findViewById(R.id.editMovieName);
        titleName.setText(titleName.getText().toString().toUpperCase());
    }

    BroadcastReceiver movieDetailsReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra(SMSReceiver.msgKey) ;
            StringTokenizer stringTokenizer= new StringTokenizer(msg,";");
            String title = stringTokenizer.nextToken();
            String yearReleased = stringTokenizer.nextToken();
            String country = stringTokenizer.nextToken();
            String genres = stringTokenizer.nextToken();
            String costs = stringTokenizer.nextToken();
            String keyword = stringTokenizer.nextToken();

            EditText movieName = findViewById(R.id.editMovieName);
            EditText year = findViewById(R.id.editYear);
            EditText countryName = findViewById(R.id.editCountry);
            EditText genre = findViewById(R.id.editGenre);
            EditText cost = findViewById(R.id.editCost);
            EditText keywords = findViewById(R.id.editKeywords);

            movieName.setText(title);
            year.setText(yearReleased);
            countryName.setText(country);
            genre.setText(genres);
            cost.setText(costs);
            keywords.setText(keyword);
        }
    };

    class NavigationListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.addMovie) {
                View view = findViewById(R.id.dl);
                addMovie(view);
            } else if (id == R.id.removeLastMovie) {
                movieList.remove(movieList.size()-1);
                myAdapter.notifyDataSetChanged();
//                movies.remove(movies.size()-1);

            } else if (id == R.id.removeAllMovies){
                movieList.clear();
                myAdapter.notifyDataSetChanged();
//                movies.clear();
                mMovieViewModel.deleteAll();
                myRef.removeValue();
            } else if (id == R.id.close){
                finish();
            } else if (id == R.id.listAllMovies){
//                String dataString = gson.toJson(movies);
//                SharedPreferences sP= getSharedPreferences("cardMovieDetails",0);
//                SharedPreferences.Editor editor = sP.edit();
//                editor.putString("movieDetailsCard",dataString);
//                editor.apply();

                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
            // close the drawer
            drawerLayout.closeDrawers();
            // tell the OS
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.clearAllFields){
            View view = findViewById(R.id.dl);
            clearAll(view);
        } else if (id == R.id.totalMovies){
            Toast.makeText(getApplicationContext(),"Total movie(s): "+movieList.size(),Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            increaseCost(constraintView, 150);
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            movieNames = findViewById(R.id.editMovieName);
            years = findViewById(R.id.editYear);
            countryNames = findViewById(R.id.editCountry);
            genres = findViewById(R.id.editGenre);
            costs = findViewById(R.id.editCost);
            keywordss = findViewById(R.id.editKeywords);
            movieNames.setText("Ip Man");
            years.setText("2008");
            countryNames.setText("China");
            genres.setText("Action, Drama, Martial Arts");
            costs.setText("50");
            keywordss.setText("Wing Chun");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            years = findViewById(R.id.editYear);
            if (distanceY==0) {
                changeYear(constraintView, -(int) distanceX);
            }
            if (distanceX==0){
                keywordss = findViewById(R.id.editKeywords);
                keywordss.setText(keywordss.getText().toString().toUpperCase());
            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (Math.abs(velocityX)+Math.abs(velocityY)>=1000){
                moveTaskToBack(true);
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }


        @Override
        public void onLongPress(MotionEvent e) {
            clearAll(constraintView);
            super.onLongPress(e);
        }

    }

    class MyScaleGestureDetector extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            keywordss= findViewById(R.id.editKeywords);
            keywordss.setText(keywordss.getText().toString().toLowerCase());
            return super.onScale(detector);
        }
    }
}