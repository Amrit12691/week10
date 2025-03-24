package com.example.wk10;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtility {
    public static List<Movie> loadMovies(Context context, String fileName) {
        List<Movie> movieList = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                // Extract values safely
                String title = obj.optString("title", "Unknown Title");
                String yearString = obj.optString("year", "0"); // Handle missing years
                int year = parseYear(yearString);
                String genre = obj.optString("genre", "Unknown Genre");
                String poster = obj.optString("poster", "default_poster");

                movieList.add(new Movie(title, year, genre, poster));
            }
        } catch (Exception e) {
            Log.e("JSONUtility", "Error parsing JSON", e);
        }
        return movieList;
    }

    // Function to parse year correctly
    private static int parseYear(String yearString) {
        try {
            return Integer.parseInt(yearString.replaceAll("[^0-9]", "")); // Extract numbers only
        } catch (Exception e) {
            return 0; // Default to unknown year
        }
    }
}
