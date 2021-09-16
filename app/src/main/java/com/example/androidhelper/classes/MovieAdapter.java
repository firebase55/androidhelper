package com.example.androidhelper.classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidhelper.R;
import com.example.androidhelper.detailsActivity;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>
{
    private Context context;
    private List movieList;

    public MovieAdapter(Context context , List movies){
        this.context = context;
        movieList = movies;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items , parent , false);
        return new MovieHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = (Movie) movieList.get(position);
        holder.rating.setText(movie.getRating().toString());
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPoster()).into(holder.imageView);
        holder.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , detailsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title" , movie.getTitle());
                bundle.putString("overview" , movie.getOverview());
                bundle.putString("poster" , movie.getPoster());
                bundle.putDouble("rating" , movie.getRating());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieList.size();

    }

    public class MovieHolder extends RecyclerView.ViewHolder
   {
       ImageView imageView;
       TextView title , overview , rating;
       LinearLayout ln;

       public MovieHolder(@NonNull View itemView) {
           super(itemView);

           imageView = itemView.findViewById(R.id.image);
           title = itemView.findViewById(R.id.movie_name);
           overview = itemView.findViewById(R.id.dess);
           rating = itemView.findViewById(R.id.star);
           ln = itemView.findViewById(R.id.lnr);
       }
   }


       }

