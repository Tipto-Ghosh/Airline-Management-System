package repositories;

import entities.User;
import interfaces.IUserRepo;
import java.io.*;

public class UserRepo implements IUserRepo {
    private static final int maxUser = 100;
    private static final String FILE_PATH = "repositories/data/user.txt";

    // Method to write the user list to the file
    public void write(User[] userList) {
        String[] userInfo = new String[maxUser];
        int count = 0;

        for (User user : userList) {
            if (user != null) {
                userInfo[count] = user.toStringUser();
                count++;
            }
        }
        FileIO fio = new FileIO();
        fio.writeFile(userInfo, FILE_PATH);
    }

    // Method to add a user to the list and write to the file
    public void addUser(User u) {
        User[] userList = this.getAllUserList();

        for (int i = 0; i < userList.length; i++) {
            if (userList[i] == null) {
                userList[i] = u;
                this.write(userList);
                return;
            }
        }
        System.err.println("Error: User list is full. Cannot add more users.");
    }

    // Method to remove a user by user ID
    public void removeUser(String key) {
        User[] userList = this.getAllUserList();

        for (int i = 0; i < userList.length; i++) {
            if (userList[i] != null && userList[i].getUserId().equals(key)) {
                userList[i] = null;
                this.write(userList);
                return;
            }
        }
        System.err.println("Error: User not found with userId: " + key);
    }

    // Method to update a user's details
    public void updateUser(User u) {
        User[] userList = this.getAllUserList();

        for (int i = 0; i < userList.length; i++) {
            if (userList[i] != null && userList[i].getUserId().equals(u.getUserId())) {
                userList[i] = u;
                this.write(userList);
                return;
            }
        }
        System.err.println("Error: User not found with userId: " + u.getUserId());
    }

    // Method to search for a user by user ID
    public User searchUserByUserId(String userId) {
        User[] userList = this.getAllUserList();

        for (User user : userList) {
            if (user != null && user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    // Method to get the list of all users from the file
    public User[] getAllUserList() {
        FileIO fio = new FileIO();
        String[] data = fio.readFile(FILE_PATH);
        User[] userList = new User[maxUser];

        if (data != null) {
            for (int i = 0; i < data.length && i < maxUser; i++) {
                if (data[i] != null && !data[i].trim().isEmpty()) {
                    User user = new User().formUser(data[i]);
                    if (user != null) {
                        userList[i] = user;
                    }
                }
            }
        }
        return userList;
    }
}
