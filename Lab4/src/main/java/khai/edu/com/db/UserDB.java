package khai.edu.com.db;

import khai.edu.com.entity.User;

import java.util.Arrays;
import java.util.UUID;

public class UserDB {
    public User[] users;
    private static UserDB instance;

    public UserDB() {
        users = new User[0];
    }

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    
    public User create(User user) {
        if(user.getId() == null)
            user.setId(generateId());
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
        return user;
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

    public User update(User user) {
        if (users.length != 0 && findById(user.getId()) != null) {
            User current = findById(user.getId());
            current.setName(user.getName());
            current.setAge(user.getAge());
            return current;
        } else {
            return createWithId(user.getId(), user);
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

    public boolean delete(String id) {
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
            return true;
        }
        else return false;
    }

    public boolean deleteWithoutId(){
        if(users.length == 0) return false;
        else {
            users = Arrays.copyOf(users, users.length-1);
            return true;
        }
    }
}