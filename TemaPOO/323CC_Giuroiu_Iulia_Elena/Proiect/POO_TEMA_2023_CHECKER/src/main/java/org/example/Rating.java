package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    @JsonProperty("username")
    public String username;
    @JsonProperty("rating")
    public int rating;
    @JsonProperty("comment")
    public String comment;

    public Rating() {}

    public Rating(String username, int rating, String comment) {
        this.username = username;
        this.rating = rating;
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return rating;
    }

    public String getComments() {
        return comment;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int rating) {
        this.rating = rating;
    }

    public void setComments(String comment) {
        this.comment = comment;
    }

    public boolean isValidRating() {
        return rating >= 1 && rating <= 10;
    }
}