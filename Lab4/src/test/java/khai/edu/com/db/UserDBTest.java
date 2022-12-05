package khai.edu.com.db;

import khai.edu.com.entity.User;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class UserDBTest {

    @Test
    void findByID(){
        UserDB userdb = new UserDB();
        User rapper = new User();
        String id = "45783845";
        rapper.setId(id);
        userdb.createWithId(id, rapper);
        Assertions.assertEquals(userdb.findById(id), rapper);
    }

    @Test
    void checkUser(){ // test user not db
        User rapper = new User();
        rapper.setAge(10);
        rapper.setName("Sasha");
        rapper.setId("100");
        Assertions.assertEquals(rapper.getId(), "100");
        Assertions.assertEquals(rapper.getAge(), 10);
        Assertions.assertEquals(rapper.getName(), "Sasha");
    }

    @Test
    void createWithId() {
        UserDB userdb = new UserDB();
        User rapper = new User();
        String id = "23oi5u";
        userdb.createWithId(id, rapper);
        Assertions.assertEquals(userdb.findById(id), rapper);
    }

    @Test
    void update() {
        UserDB userdb = new UserDB();
        User user = new User();
        user.setId("oifh");
        user.setName("Sashka Shlyapik");
        userdb.update(user);
        Assertions.assertEquals(userdb.findById(user.getId()), user);
    }

}