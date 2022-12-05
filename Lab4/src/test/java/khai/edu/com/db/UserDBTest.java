package khai.edu.com.db;

import khai.edu.com.entity.User;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class UserDBTest {
    @Test
    void findByID(){
        User rapper = new User();
        String id = "45783845";
        UserDB.getInstance().createWithId(id, rapper);
        Assertions.assertEquals(UserDB.getInstance().findById(id).getName(), rapper.getName());
    }

    @Test
    void createWithId() {
        User rapper = new User();
        String id = "23oi5u";
        UserDB.getInstance().createWithId(id, rapper);
        Assertions.assertEquals(UserDB.getInstance().findById(id).getName(), rapper.getName());
    }

    @Test
    void update() {
        User user = new User();
        user.setId("oifh");
        user.setName("Sashka Shlyapik");
        UserDB.getInstance().update(user);
        Assertions.assertEquals(UserDB.getInstance().findById(user.getId()).getName(), user.getName());
    }

}