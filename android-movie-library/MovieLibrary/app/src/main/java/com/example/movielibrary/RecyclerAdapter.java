package com.example.movielibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movielibrary.provider.Movie;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

//    ArrayList<Movie> movieDetails;
    List<Movie> data = new ArrayList<>();



    public RecyclerAdapter(){

    }

    public void setData(List<Movie> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText  ("  Title    "+data.get(position).getTitle());
        holder.year.setText   ("  Year     "+data.get(position).getYear());
        holder.country.setText("  Country  "+data.get(position).getCountry());
        holder.genre.setText  ("  Genre    "+data.get(position).getGenre());
        holder.cost.setText   ("  Cost     "+data.get(position).getCost());
        holder.keyword.setText("  Keywords "+data.get(position).getKeywords());

        final int fPosition = position;
        final String cardTitle = data.get(position).getTitle();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Movie No."+ fPosition+" with Title:"+
                        cardTitle+" is selected",Toast.LENGTH_SHORT).show();
                MainActivity2.mMovieViewModel.deleteByYear(data.get(fPosition));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView year;
        public TextView country;
        public TextView genre;
        public TextView cost;
        public TextView keyword;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title =itemView.findViewById(R.id.cardTitle);
            year = itemView.findViewById(R.id.cardYear);
            country = itemView.findViewById(R.id.cardCountry);
            genre = itemView.findViewById(R.id.cardGenre);
            cost = itemView.findViewById(R.id.cardCost);
            keyword= itemView.findViewById(R.id.cardKeyword);
        }
    }
}
