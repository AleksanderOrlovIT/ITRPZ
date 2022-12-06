package khai.edu.com.service;

import khai.edu.com.dao.UserDao;
import khai.edu.com.entity.User;

public class UserService {

    private static final UserDao userDao = new UserDao();

    public static User create(User user) {
        return userDao.create(user);
    }

    public static User update(User user) {
        return userDao.update(user);
    }

    public static boolean delete(String id) {
        return userDao.delete(id);
    }

    public static boolean deleteWithoutId(){
        return userDao.deleteWithoutId();
    }

    public static User findById(String id) {
        return userDao.findById(id);
    }

    public static User[] findAll() {
        return userDao.findAll();
    }
}