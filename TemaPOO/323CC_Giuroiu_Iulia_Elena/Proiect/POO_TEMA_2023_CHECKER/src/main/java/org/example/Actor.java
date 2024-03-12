package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    @JsonProperty("name")
    private String name;
    @JsonProperty("performances")
    public List<Performance> performances;
    @JsonProperty("biography")
    private String biography;

    // Constructor implicit necesar pentru Jackson
    public Actor() {
        this.performances = new ArrayList<>();
    }

    public Actor(String name, String biography, List<Performance> performances) {
        this.name = name;
        this.biography = biography;
        this.performances = new ArrayList<>(performances);
    }

    public void addPerformance(String movieOrSeriesName, String type) {
        performances.add(new Performance(movieOrSeriesName, type));
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<Performance> performances){ this.performances = performances;}

    public String getBiography() {
        return biography;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Name: ").append(name).append("\n");
        details.append("Biography: ").append(biography).append("\n");

        if (performances != null && !performances.isEmpty()) {
            details.append("Performances:\n");
            for (Performance performance : performances) {
                details.append("\tTitle: ").append(performance.getName()).append("\n");
                // Include other details of the performance if necessary
            }
        } else {
            details.append("No performances available.\n");
        }

        return details.toString();
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public static class Performance {
        @JsonProperty("title")
        public String title;
        @JsonProperty("type")
        public String type;

        // Constructor implicit necesar pentru Jackson
        public Performance() {
        }

        public Performance(String title, String type) {
            this.title = title;
            this.type = type;
        }

        // Getter and setter methods for Performance

        public String getName() {
            return title;
        }

        public void setName(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
