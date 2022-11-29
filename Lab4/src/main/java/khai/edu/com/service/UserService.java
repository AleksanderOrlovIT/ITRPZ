package khai.edu.com.service;

import khai.edu.com.dao.UserDao;
import khai.edu.com.entity.User;

public class UserService {

    private static final UserDao userDao = new UserDao();

    public static void create(User user) {
        userDao.create(user);
    }

    public static void update(User user) {
        userDao.update(user);
    }

    public static void delete(String id) {
        userDao.delete(id);
    }

    public static User findById(String id) {
        return userDao.findById(id);
    }

    public static User[] findAll() {
        return userDao.findAll();
    }
}
