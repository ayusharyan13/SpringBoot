package com.example.spring1;

import java.util.ArrayList;
import java.util.List;

public class DBUser {
    private List<User> userTable = new ArrayList<User>();

    public DBUser() {
        userTable.add(new User("Tejender bhosdi ka" +
                "Chacha", 1, 30));
        userTable.add(new User("Raka", 2, 40));
    }

    public List<User> getAllUsers() {
        return userTable;
    }

    public User getAUser(int id) {
        for(User user : userTable) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User getAUserByName(String name) {
        for(User user : userTable) {
            if(user.getName().equals(name)) return user;
        }
        return null;
    }

    public User addUser(User user) {
        userTable.add(user);
        return user;
    }

    public boolean deleteAUser(int id) {
        for (User user : userTable) {
            if(user.getId() ==  id) {
                userTable.remove(user);
                return true;
            }
        }
        return false; // if that user is not present then return false;
    }

}
