package com.example.wk10;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        errorText = findViewById(R.id.errorText);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            List<Movie> movieList = JSONUtility.loadMovies(this, "movies.json");
            movieAdapter = new MovieAdapter(movieList);
            recyclerView.setAdapter(movieAdapter);
        } catch (Exception e) {
            Log.e("MainActivity", "Error loading movies", e);
            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Error loading movies. Please check the data.");
        }
    }
}