package edu.birzeit.sport.Data;

import edu.birzeit.sport.models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {
    private static ArrayList<Player> players;

    public PlayerData() {
        players = new ArrayList<>();
        players.add(new Player(0, "Cristiano", "Ronaldo", 134));
        players.add(new Player(1, "Lionel", "Messi", 120));
        players.add(new Player(2, "Robert ", "Lewandowski", 80));
        players.add(new Player(3, "Kareem ", "Benzima", 78));

    }

    public List<Player> getPlayerList() {
        return players;
    }

    public String[] getTeams() {
        String[] teams = {"Realmadrid", "manchester united", "juventus"};
        return teams;
    }
}
