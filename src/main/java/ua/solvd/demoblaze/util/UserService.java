package ua.solvd.demoblaze.util;

import ua.solvd.demoblaze.model.User;

public class UserService {
    private UserService() {
    }

    public static User createRandomUser() {
        String username = "TestUser_" + System.currentTimeMillis();
        String password = "StrongPassword123!";
        return new User(username, password);
    }

    public static User createPredefinedUser() {
        String username = "demoblazetestuser1234";
        String password = "demoblazepassword1234";
        return new User(username, password);
    }
}