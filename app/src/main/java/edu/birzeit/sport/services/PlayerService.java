package edu.birzeit.sport.services;

import edu.birzeit.sport.Data.PlayerData;
import edu.birzeit.sport.models.Player;
import edu.birzeit.sport.repositories.Repository;

import java.util.ArrayList;
import java.util.List;

public class PlayerService implements Repository<Player> {
    private PlayerData playerData = new PlayerData();
    private static PlayerService playerService;

    private PlayerService() {
    }

    public static PlayerService getPlayerService() {
        if (playerService == null) {
            playerService = new PlayerService();
        }
        return playerService;
    }


    @Override
    public List<Player> findAll() {
        return playerData.getPlayerList();
    }

    @Override
    public Player findById(int id) {
        return null;
    }

    @Override
    public Player save(Player player) {
        return null;
    }

    @Override
    public void deleteById(int id) {
    }

    public List<String> getPlayersNames() {
        List<Player> playerArrayList = findAll();
        ArrayList<String> players = new ArrayList<>();
        String name = "";
        for (int i = 0; i < playerArrayList.size(); i++) {
            name = playerArrayList.get(i).getFirstName() + " " + playerArrayList.get(i).getLastName();
            players.add(name);
        }
        return players;
    }

    public String[] getTeams() {
        return playerData.getTeams();
    }
}
