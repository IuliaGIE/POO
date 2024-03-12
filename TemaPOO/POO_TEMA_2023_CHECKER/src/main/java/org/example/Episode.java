package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode {
    @JsonProperty("episodeName")
    public String episodeName; // Numele episodului
    @JsonProperty("duration")
    public String duration; // Durata episodului in minute
    public String additionalDetails; // Alte detalii opționale

    public Episode() {}

    public Episode(String episodeName, String duration, String additionalDetails) {
        this.episodeName = episodeName;
        this.duration = duration;
        this.additionalDetails = additionalDetails;
    }

    // Metoda pentru afișarea informațiilor despre episod
    public void displayInfo() {
        System.out.println("Episode Name: " + episodeName);
        System.out.println("Duration: " + duration + " minutes");
        if (additionalDetails != null && !additionalDetails.isEmpty()) {
            System.out.println("Additional Details: " + additionalDetails);
        }
    }

    // Getter and setter methods for name, duration, and additionalDetails
    public String getName() {
        return episodeName;
    }

    public void setName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}
