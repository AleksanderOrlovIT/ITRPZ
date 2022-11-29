package khai.edu.com.db;

import khai.edu.com.entity.User;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class UserDBTest {
    UserDB userdb;
    @Test
    void findByID(){
        User rapper = new User();
        String id = "45783845";
        rapper.setId(id);
        Assertions.assertEquals(userdb.findById(id), rapper);
    }

    @Test
    void createWithId() {
        User rapper = new User();
        String id = "23oi5u";
        userdb.createWithId(id, rapper);
        Assertions.assertEquals(userdb.findById(id), rapper);
    }

    @Test
    void update() {
        User user = new User();
        user.setId("oifh");
        user.setName("Sashka Shlyapik");
        userdb.update(user);
        Assertions.assertEquals(userdb.findById(user.getId()), user);
    }

}