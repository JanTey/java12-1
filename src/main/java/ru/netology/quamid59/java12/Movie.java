package ru.netology.quamid59.java12;

public class Movie {
    private int id;
    private String movieName;

    public Movie(String s, String movieName) {
    }

    public Movie(int id, String movieName) {
        this.id = id;
        this.movieName = movieName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int get() {
        return id;
    }
}