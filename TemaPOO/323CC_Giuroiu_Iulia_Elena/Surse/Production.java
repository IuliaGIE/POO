package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;
import java.util.stream.Collectors;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Movie.class, name = "Movie"),
        @JsonSubTypes.Type(value = Series.class, name = "Series")
})

public abstract class Production implements Comparable<Production> {
    @JsonProperty("title")
    private String title;
    @JsonProperty("directors")
    private List<String> directors;
    @JsonProperty("actors")
    private List<String> actors;
    @JsonProperty("genres")
    private List<Genre> genres;
    @JsonProperty("ratings")
    private List<Rating> ratings;
    @JsonProperty("plot")
    private String plot;
    @JsonProperty("averageRating")
    private double averageRating;

    // Jackson needs a no-argument constructor for deserialization
    protected Production() {}

    public Production(String title, List<String> directors, List<String> actors, List<Genre> genres, List<Rating> ratings, String plot) {
        this.title = title;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
        this.ratings = ratings;
        this.plot = plot;
        this.averageRating = calculateAverageRating();
    }

    private double calculateAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Rating rating : ratings) {
            sum += rating.getScore();
        }
        return sum / ratings.size();
    }

    public abstract void displayInfo();

    @Override
    public int compareTo(Production other) {
        return this.title.compareTo(other.title);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public String getPlot() {
        return plot;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Title: ").append(getTitle()).append("\n");

        // Assuming you have methods like getDirectors(), getActors(), etc.
        details.append("Directors: ").append(String.join(", ", getDirectors())).append("\n");
        details.append("Actors: ").append(String.join(", ", getActors())).append("\n");
        details.append("Genres: ").append(getGenres().stream().map(Genre::toString).collect(Collectors.joining(", "))).append("\n");
        details.append("Plot: ").append(getPlot()).append("\n");
        details.append("Average Rating: ").append(getAverageRating()).append("\n");

        // Additional details for Movie or Series specific fields
        if (this instanceof Movie) {
            Movie movie = (Movie) this;
            details.append("Duration: ").append(movie.getDuration()).append("\n");
            details.append("Release Year: ").append(movie.getReleaseYear()).append("\n");
        } else if (this instanceof Series) {
            Series series = (Series) this;
            details.append("Release Year: ").append(series.getReleaseYear()).append("\n");
            details.append("Number of Seasons: ").append(series.getNumberOfSeasons()).append("\n");
        }

        return details.toString();
    }


    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        this.averageRating = calculateAverageRating();
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
