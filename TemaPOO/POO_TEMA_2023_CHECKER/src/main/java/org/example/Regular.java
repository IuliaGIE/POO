package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Regular<T extends Comparable<T>> extends User<T> implements RequestsManager {
    public Regular(){}
    public Regular(@JsonProperty("information") Information userInfo,
                   @JsonProperty("userType") AccountType accountType) {
        super(userInfo, accountType);
    }

    @Override
    public void createRequest(Request r) {
        RequestsHolder.addRequest(r);
    }

    @Override
    public void removeRequest(Request r) {
        // Implement logic to remove a request
        RequestsHolder.removeRequest(r);
    }

    public void addReview(Rating rating) {
        if (!rating.isValidRating()) {
            return;
        }
        if (getFavorites().contains(rating)) {
            System.out.println("You have already reviewed this item.");
            return;
        }
        addFavorite((T) rating);
        updateExperience(rating.getScore());
        System.out.println("Review added for " + rating.getUsername());
    }
}
