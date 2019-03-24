package io.javabrains.movieinfoservice.models;

public class Movie {


    private String movieid;
    private String name;

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie(String movieid, String name) {
        this.movieid = movieid;
        this.name = name;
    }
}
