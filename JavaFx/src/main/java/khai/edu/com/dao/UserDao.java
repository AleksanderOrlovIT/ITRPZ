package khai.edu.com.dao;

import khai.edu.com.db.UserDB;
import khai.edu.com.entity.User;

public class UserDao {
    public User create(User user) {
        return UserDB.getInstance().create(user);
    }

    public User update(User user) {
        return UserDB.getInstance().update(user);
    }

    public boolean delete(String id) {return UserDB.getInstance().delete(id);}

    public boolean deleteWithoutId(){return UserDB.getInstance().deleteWithoutId();}

    public User findById(String id) { return UserDB.getInstance().findById(id); }

    public User[] findAll() { return UserDB.getInstance().findAll(); }
}