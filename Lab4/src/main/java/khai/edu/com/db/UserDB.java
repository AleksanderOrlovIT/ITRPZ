package khai.edu.com.db;

import khai.edu.com.entity.User;

import java.util.Arrays;
import java.util.UUID;

public class UserDB {
    private User[] users;
    private static UserDB instance;

    private UserDB() {
        users = new User[0];
    }

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
    }

    public User createWithId(String id, User user) {
        user.setId(id);
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
        return users[users.length - 1];
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < users.length; i++)
            if (id.equals(String.valueOf(users[i].getId()))) {
                return generateId();
            }
        return id;
    }

    public void update(User user) {
        if (users.length != 0 && findById(user.getId()) != null) {
            User current = findById(user.getId());
            current.setName(user.getName());
            current.setAge(user.getAge());
        } else {
            createWithId(user.getId(), user);
        }
    }

    public User findById(String id) {
        for (int i = 0; i < users.length; i++) {
            if (id.equals(String.valueOf(users[i].getId()))) return users[i];
        }
        return null;
    }

    public User[] findAll() {
        return users;
    }

    public void delete(String id) {
        User userToDelete = findById(id);
        if (findById(id) != null) {
            int temp = -1;
            for (int i = 0; i < users.length; i++) {
                if (users[i].getId().equals(String.valueOf(userToDelete.getId()))) {
                    users[i] = null;
                    temp = i;
                }
            }
            User tempArray[] = new User[users.length - 1];
            for (int i = 0; i < temp; i++) {
                tempArray[i] = users[i];
            }
            for (int i = temp; i < tempArray.length; i++) {
                tempArray[i] = users[i + 1];
            }
            users = Arrays.copyOf(tempArray, users.length - 1);
        }
        else System.out.println("No such id");
    }
}
