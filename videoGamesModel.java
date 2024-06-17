package org.example.assignment1java;

public class videoGamesModel {
    private String videoGameName;
    private String platform;
    private int releaseYear;
    private float rating;
    private int sales;

    public videoGamesModel(String videoGameName, String platform, int releaseYear, float rating, int sales) {
        this.videoGameName = videoGameName;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.sales = sales;
    }

    public String getVideoGameName() {
        return videoGameName;
    }

    public void setVideoGameName(String videoGameName) {
        this.videoGameName = videoGameName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
