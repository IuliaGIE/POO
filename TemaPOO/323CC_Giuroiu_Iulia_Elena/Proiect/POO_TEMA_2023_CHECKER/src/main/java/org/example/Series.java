package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Series extends Production {
    @JsonProperty("releaseYear")
    public int releaseYear; // Anul lansarii seriei
    @JsonProperty("numSeasons")
    public int numSeasons; // Numarul de sezoane ale seriei
    @JsonProperty("seasons")
    private Map<String, List<Episode>> seasons; // sezoane si episoade

    public Series() {}

    public Series(String title, List<String> directors, List<String> actors, List<Genre> genres, List<Rating> ratings, String description, int releaseYear, int numSeasons, Map<String, List<Episode>> seasons) {
        super(title, directors, actors, genres, ratings, description);
        this.releaseYear = releaseYear;
        this.numSeasons = numSeasons;
        this.seasons = seasons;
    }

    @Override
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Number of Seasons: " + numSeasons);
        System.out.println("Seasons and Episodes:");
        for (Map.Entry<String, List<Episode>> seasonEntry : seasons.entrySet()) {
            System.out.println("Season: " + seasonEntry.getKey());
            for (Episode episode : seasonEntry.getValue()) {
                episode.displayInfo();
            }
        }
    }

    // Getter and setter methods for releaseYear, numSeasons, and seasons
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getNumberOfSeasons() {
        return numSeasons;
    }

    public void setNumberOfSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    public Map<String, List<Episode>> getSeasons() {
        return seasons;
    }

    public void setSeasons(Map<String, List<Episode>> seasons) {
        this.seasons = seasons;
    }
}
