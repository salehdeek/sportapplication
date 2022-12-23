package edu.birzeit.sport.services;

import edu.birzeit.sport.Data.UserData;
import edu.birzeit.sport.models.User;
import edu.birzeit.sport.repositories.Repository;

import java.util.List;

public class UserService implements Repository<User> {
    private UserData userData = new UserData();
    private static UserService userService;


    private UserService() {

    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    @Override
    public List<User> findAll() {
        return userData.getUsers();
    }

    @Override
    public User findById(int id) {
        return userData.getUserById(id);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    public String isFindUser(String email, String password) {
        User user = new User(email, password);
        return (userData.isFindUser(user));
    }


}
