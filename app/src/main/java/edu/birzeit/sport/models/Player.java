package edu.birzeit.sport.models;

public class Player extends User {
    private int goals;


    public Player(int id, String firstName, String lastName, int goals) {
        super(id, firstName, lastName);
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
