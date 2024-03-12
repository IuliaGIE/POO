package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Movie extends Production {
    @JsonProperty("duration")
    public String duration; // Durata filmului in minute
    @JsonProperty("releaseYear")
    public int releaseYear; // Anul lansarii filmului
    public String additionalDetails; // Alte detalii opționale

    public Movie() {}

    public Movie(String title, List<String> directors, List<String> actors, List<Genre> genres, List<Rating> ratings, String description, String duration, int releaseYear, String additionalDetails) {
        super(title, directors, actors, genres, ratings, description);
        this.duration = duration;
        this.releaseYear = releaseYear;
        this.additionalDetails = additionalDetails;
    }

    @Override
    public void displayInfo() {
        // Implementarea metodei pentru afișarea informațiilor despre film
        System.out.println("Title: " + getTitle());
        System.out.println("Directors: " + getDirectors());
        System.out.println("Actors: " + getActors());
        System.out.println("Genres: " + getGenres());
        System.out.println("Description: " + getPlot());
        System.out.println("Average Rating: " + getAverageRating());
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Release Year: " + releaseYear);
        if (additionalDetails != null && !additionalDetails.isEmpty()) {
            System.out.println("Additional Details: " + additionalDetails);
        }
    }

    // Getter and setter methods for duration, releaseYear, and additionalDetails
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}
