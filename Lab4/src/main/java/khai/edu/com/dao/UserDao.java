package khai.edu.com.dao;

import khai.edu.com.db.UserDB;
import khai.edu.com.entity.User;

public class UserDao {
    public void create(User user) {
        UserDB.getInstance().create(user);
    }

    public void update(User user) {
        UserDB.getInstance().update(user);
    }

    public void delete(String id) {UserDB.getInstance().delete(id);}

    public User findById(String id) { return UserDB.getInstance().findById(id); }

    public User[] findAll() { return UserDB.getInstance().findAll(); }

}
