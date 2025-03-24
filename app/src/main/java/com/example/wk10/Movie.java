package com.example.wk10;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String poster;

    public Movie(String title, int year, String genre, String poster) {
        this.title = (title != null && !title.equals("null") && !title.isEmpty()) ? title : "Unknown Title";
        this.year = (year >= 1800 && year <= 2100) ? year : 0; // Ensure valid year
        this.genre = (genre != null && !genre.equals("null") && !genre.isEmpty()) ? genre : "Unknown Genre";
        this.poster = (poster != null && !poster.equals("null") && !poster.isEmpty()) ? poster : "default_poster";
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public String getPoster() { return poster; }
}
: