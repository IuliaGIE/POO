package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "userType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "Admin"),
        @JsonSubTypes.Type(value = Regular.class, name = "Regular"),
        @JsonSubTypes.Type(value = Contributor.class, name = "Contributor")
})
public abstract class User<T extends Comparable<T>> implements Comparable<User<T>> {
    private static int uniqueIdCounter = 1;

    @JsonProperty("information")
    protected Information information;
    @JsonProperty("userType")
    protected AccountType userType;
    @JsonProperty("username")
    protected String username;
    @JsonProperty("experience")
    protected int experience;
    @JsonProperty("notifications")
    protected List<String> notifications;
    SortedSet<T> favorites = new TreeSet<>();

    @JsonProperty("productionsContribution")
    private List<String> productionsContribution;
    @JsonProperty("actorsContribution")
    private List<String> actorsContribution;
    @JsonProperty("favoriteProductions")
    private List<String> favoriteProductions;
    @JsonProperty("favoriteActors")
    private List<String> favoriteActors;

    public User() {
    }

    public User(Information information, AccountType userType) {
        this.information = information;
        this.userType = userType;
        this.username = generateUniqueUsername(information.getName());
        this.experience = 0;
        this.notifications = new ArrayList<>();
        this.favorites = new TreeSet<>();
        this.productionsContribution = new ArrayList<>();
        this.actorsContribution = new ArrayList<>();
        this.favoriteProductions = new ArrayList<>();
        this.favoriteActors = new ArrayList<>();
    }


    public Information getinformation() {
        return information;
    }

    public Credentials getCredentials(){ return information.credentials;}

    public AccountType getuserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public int getExperience() {
        return experience;
    }

    public int highExperience(){
        experience = experience + 1;
        return experience;
    }

    public int lowExperience(){
        experience = experience - 1;
        return experience;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public SortedSet<T> getFavorites() {
        return favorites;
    }

    public void addFavorite(T favorite) {
        favorites.add(favorite);
    }

    public void removeFavorite(T favorite) {
        favorites.remove(favorite);
    }

    public void updateExperience(int points) {
        if (userType != userType.Admin) {
            experience += points;
        }
    }

    public void addProductionContribution(String production) {
        productionsContribution.add(production);
    }

    public void addActorContribution(String actor) {
        actorsContribution.add(actor);
    }

    public void addFavoriteProduction(String production) {
        favoriteProductions.add(production);
    }

    public void addFavoriteActor(String actor) {
        favoriteActors.add(actor);
    }

    public void removeFavoriteProduction(String production) {
        favoriteProductions.remove(production);
    }

    public void removeFavoriteActor(String actor) {
        favoriteActors.remove(actor);
    }

    // Implementarea metodei de logout
    public void logout() {
        System.out.println("Logout successful. Goodbye, " + getUsername() + "!");
    }

    private void resetUserState() {
        this.information = null;
        this.userType = null;
        this.username = null;
        this.experience = 0;
        this.notifications.clear();
        this.favorites.clear();
        this.productionsContribution.clear();
        this.actorsContribution.clear();
        this.favoriteProductions.clear();
        this.favoriteActors.clear();
    }

    private String generateUniqueUsername(String baseName) {
        return baseName.toLowerCase().replace(" ", "_") + "_" + uniqueIdCounter++;
    }

    // In clasa User
    public void addReview(T review) {
        if (this.userType == userType.Regular && review instanceof Rating) {
            Rating rating = (Rating) review;
            if (rating.isValidRating()) {

                boolean alreadyReviewed = favorites.stream()
                        .anyMatch(fav -> fav instanceof Rating && ((Rating) fav).getUsername().equals(rating.getUsername()));

                if (!alreadyReviewed) {
                    favorites.add(review);
                    updateExperience(rating.getScore());
                } else {
                    System.out.println("You have already reviewed this product.");
                }
            } else {
                System.out.println("Invalid rating score.");
            }
        } else {
            System.out.println("Only regular users can add reviews.");
        }
    }


    @Override
    public int compareTo(User<T> otherUser) {
        return Integer.compare(otherUser.experience, this.experience);
    }

    public static class Information {
        @JsonProperty("credentials")
        private Credentials credentials;
        @JsonProperty("name")
        private String name;
        @JsonProperty("country")
        private String country;
        @JsonProperty("age")
        private int age;
        @JsonProperty("gender")
        private String gender; // Female, Male, sau Neutral
        @JsonProperty("birthDate")
        private String birthDate;

        public Information(){

        }

        public Information(String name, String country, int age, String gender, String birthDate, String email, String password) {
            this.credentials = new Credentials(email, password);
            this.name = name;
            this.country = country;
            this.age = age;
            this.gender = gender;
            this.birthDate = birthDate;
        }

        // Getter and setter methods
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public Credentials getCredentials() {
            return credentials;
        }

        public void setCredentials(String email, String password) {
            this.credentials.setEmail(email);
            this.credentials.setPassword(password);
        }
    }
}