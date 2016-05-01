package me.salai.codingchallenges.movies;

import java.sql.Time;

/**
 * Movie class
 * Holds the details of a Movie as given by user
 */
public class Movie {
    private String movieName;
    private String duration;
    private String language;
    private String leadActor;
    private String genre;

    public Movie(){
    }

    // All Properties Constructor
    public Movie(String movieName, String duration, String language, String leadActor, String genre ){
        this.movieName  = movieName;
        this.duration   = duration;
        this.language   = language;
        this.leadActor  = leadActor;
        this.genre      = genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!movieName.equals(movie.movieName)) return false;
        if (duration != null ? !duration.equals(movie.duration) : movie.duration != null) return false;
        if (language != null ? !language.equals(movie.language) : movie.language != null) return false;
        if (leadActor != null ? !leadActor.equals(movie.leadActor) : movie.leadActor != null) return false;
        return genre != null ? genre.equals(movie.genre) : movie.genre == null;

    }

    @Override
    public int hashCode() {
        int result = movieName.hashCode();
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (leadActor != null ? leadActor.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", leadActor='" + leadActor + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
