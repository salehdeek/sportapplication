package edu.birzeit.sport.services;

public class LoginService {
    private static UserService userService = UserService.getUserService();

    public String loginStatus(String email, String password) {
        return (userService.isFindUser(email, password));
    }


}
