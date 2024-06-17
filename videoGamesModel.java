package org.example.assignment1java;

// Model class to represent video game data
public class videoGamesModel {
    // Private fields for the video game attributes
    private String videoGameName;
    private String platform;
    private int releaseYear;
    private float rating;
    private int sales;

    // Constructor to initialize the video game model with given values
    public videoGamesModel(String videoGameName, String platform, int releaseYear, float rating, int sales) {
        this.videoGameName = videoGameName;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.sales = sales;
    }

    // Getter method for video game name
    public String getVideoGameName() {
        return videoGameName;
    }

    // Setter method for video game name
    public void setVideoGameName(String videoGameName) {
        this.videoGameName = videoGameName;
    }

    // Getter method for platform
    public String getPlatform() {
        return platform;
    }

    // Setter method for platform
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    // Getter method for release year
    public int getReleaseYear() {
        return releaseYear;
    }

    // Setter method for release year
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    // Getter method for rating
    public float getRating() {
        return rating;
    }

    // Setter method for rating
    public void setRating(float rating) {
        this.rating = rating;
    }

    // Getter method for sales
    public int getSales() {
        return sales;
    }

    // Setter method for sales
    public void setSales(int sales) {
        this.sales = sales;
    }
}

