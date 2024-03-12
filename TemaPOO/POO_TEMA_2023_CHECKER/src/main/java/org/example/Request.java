package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Request {
    public RequestTypes type;
    @JsonProperty("createdDate")
    public String creationDate;
    public String titleOrActorName;
    public String description;
    public String requestingUser;
    public String assignedUser;


    // Constructor gol pentru Jackson
    @JsonCreator
    public Request() {
    }

    // Constructor cu toate proprietațile
    public Request(RequestTypes type, String creationDate, String description, String requestingUser, String assignedUser) {
        this.type = type;
        this.creationDate = creationDate;
        this.description = description;
        this.requestingUser = requestingUser;
        this.assignedUser = assignedUser;
    }



    // Getteri pentru Jackson
    @JsonProperty("type")
    public RequestTypes getType() {
        return type;
    }

    @JsonProperty("createdDate")
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty("username")
    public String getRequestingUser() {
        return requestingUser;
    }

    @JsonProperty("to")
    public String getAssignedUser() {
        return assignedUser;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("actorName")
    public String getActorName() {
        return this.type == RequestTypes.ACTOR_ISSUE ? titleOrActorName : null;
    }

    @JsonProperty("movieTitle")
    public String getMovieTitle() {
        return this.type == RequestTypes.MOVIE_ISSUE ? titleOrActorName : null;
    }

    @JsonProperty("actorName")
    public void setActorName(String actorName) {
        if (this.type == RequestTypes.ACTOR_ISSUE) {
            this.titleOrActorName = actorName;
        }
    }

    @JsonProperty("movieTitle")
    public void setMovieTitle(String movieTitle) {
        if (this.type == RequestTypes.MOVIE_ISSUE) {
            this.titleOrActorName = movieTitle;
        }
    }

    // Setters

    // Setter pentru titlul sau numele actorului
    public void setTitleOrActorName(String titleOrActorName) {
        this.titleOrActorName = titleOrActorName;
    }

    public String getFormattedCreationDate() {
        return creationDate;
    }



    // Metoda pentru a determina utilizatorul asignat
    public void determineAssignedUser() {
        this.assignedUser = type == RequestTypes.DELETE_ACCOUNT || type == RequestTypes.OTHERS ? "ADMIN" : "user-specific-logic";
    }
}
