package com.example.wk10;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleText, yearText, genreText;

    public MovieViewHolder(View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.movieTitle);
        yearText = itemView.findViewById(R.id.movieYear);
        genreText = itemView.findViewById(R.id.movieGenre);
    }

    public void bind(Movie movie) {
        titleText.setText(movie.getTitle());
        yearText.setText(movie.getYear() > 0 ? String.valueOf(movie.getYear()) : "Unknown Year");
        genreText.setText(movie.getGenre());
    }
}
