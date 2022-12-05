package khai.edu.com.dao;

import khai.edu.com.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class UserDaoTest {
    private UserDao userDao;

    @BeforeEach
    void setUp() {
        this.userDao = new UserDao();
        while (userDao.findAll().length != 0){
            userDao.deleteWithoutId();
        }
    }

    @Test
    public void createUserWithId(){
        userDao.create(new User("Rian", 18, "1"));
        User rian = userDao.findById("1");
        assertThat(rian).isNotNull();
        assertThat(rian.getName()).isEqualTo("Rian");
        assertThat(rian.getAge()).isEqualTo(18);
    }

    @Test
    public void createUserWithoutIdAndFindAll(){
        userDao.create(new User("Monica", 20));
        assertThat(userDao.findAll()).isNotNull();
        User[] users = userDao.findAll();
        assertThat(users[0].getName()).isEqualTo("Monica");
        assertThat(users[0].getAge()).isEqualTo(20);
        assertThat(users[0].getId()).isNotNull();
    }

    @Test
    public void updateUser(){
        userDao.create(new User("Monica", 20, "1"));
        userDao.update(new User("Rebecca", 21, "1"));
        User rebecca = userDao.findById("1");
        assertThat(rebecca).isNotNull();
        assertThat(rebecca.getName()).isEqualTo("Rebecca");
        assertThat(rebecca.getAge()).isEqualTo(21);
        User[] users = userDao.findAll();
        assertThat(users[0].getId()).isEqualTo("1");
        assertThat(users[0].getName()).isEqualTo("Rebecca");
        assertThat(users[0].getAge()).isEqualTo(21);
    }
    @Test
    public void deleteUserWithId(){
        userDao.create(new User("Monica", 20, "1"));
        assertThat(userDao.findAll().length).isEqualTo(1);
        userDao.delete("1");
        User rebecca = userDao.findById("1");
        assertThat(rebecca).isNull();
        User[] users = userDao.findAll();
        assertThat(users.length).isEqualTo(0);
    }

    @Test
    public void deleteWithoutId(){
        userDao.create(new User("Monica", 20, "1"));
        User[] users = userDao.findAll();
        assertThat(users.length).isEqualTo(1);
        userDao.deleteWithoutId();
        users = userDao.findAll();
        assertThat(users.length).isEqualTo(0);
    }
}
