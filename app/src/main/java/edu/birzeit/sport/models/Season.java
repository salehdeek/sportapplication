package edu.birzeit.sport.models;

public class Season {
    private int year;
    private String winnerTeam;
    private String imageUrl;

    public Season(int year, String winnerTeam, String imageUrl) {
        this.year = year;
        this.winnerTeam = winnerTeam;
        this.imageUrl = imageUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
