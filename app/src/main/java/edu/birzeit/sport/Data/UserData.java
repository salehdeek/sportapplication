package edu.birzeit.sport.Data;

import edu.birzeit.sport.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static ArrayList<User> users;

    public UserData() {
        users = new ArrayList<>();
        users.add(new User(0, "saleh", "deek", "salehdeek", "Saleh@321", "saleh@gmail.com"));
        users.add(new User(1, "Samir", "Zein", "samir00", "samir11", "samir@gmail.com"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }

        }
        return null;
    }

    public String isFindUser(User user) {
        for (User user1 : users) {
            if (user1.getEmail().equals(user.getEmail()) && user1.getPassword().equals(user.getPassword()))
                return user1.getUserName();
        }
        return null;
    }


}
