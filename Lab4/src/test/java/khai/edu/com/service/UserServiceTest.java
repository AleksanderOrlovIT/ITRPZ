package khai.edu.com.service;

import khai.edu.com.dao.UserDao;
import khai.edu.com.db.UserDB;
import khai.edu.com.entity.User;
import khai.edu.com.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {
    @Mock
    private UserDao userDao;
    @Mock
    private UserDB userDB = new UserDB();

    private UserService userService;

    @BeforeEach
    void setUp() {
        UserDB.getInstance().users = new User[0];
    }

    public UserServiceTest(){
        MockitoAnnotations.initMocks(this);
        this.userService = new UserService();
    }

    @Test
    public void findById(){
        given(userDao.findById("1"))
                .willReturn(UserDB.getInstance().create(new User("Sasha", 19, "1")));
        assertThat(userService.findById("1").getName()).isEqualTo("Sasha");
    }

    @Test
    public void findAll(){
        given(userDao.findAll())
                .willReturn(UserDB.getInstance().users);
        assertThat(userService.findAll().length).isEqualTo(0);
    }

    @Test
    public void createUserWithId(){
        given(userDao.create(new User("Adolf", 54, "2")))
                .willReturn(UserDB.getInstance().create(new User("Adolf", 54, "2")));
        assertThat(userService.findById("2").getName()).isEqualTo("Adolf");
    }

    @Test void createUserWithoutId(){
        given(userDao.create(new User("Petro", 31)))
                .willReturn(UserDB.getInstance().create(new User("Petro", 31)));
        assertThat(userService.findAll().length).isEqualTo(1);
    }

    @Test
    public void updateUser(){
        given(userDao.update(new User("Denys", 12, "3")))
                .willReturn(UserDB.getInstance().update(new User("Denys", 12, "3")));
        assertThat(userService.findById("3").getName()).isEqualTo("Denys");
    }

    @Test
    void deleteUserWithIdFalse(){
        given(userDao.delete("1"))
                .willReturn(UserDB.getInstance().delete("1"));
        assertThat(userService.findAll().length).isEqualTo(0);
        assertThat(userService.delete("1")).isFalse();
    }

    @Test
    void deleteUserWithIdTrue(){
        given(userDao.create(new User()))
                .willReturn(UserDB.getInstance().create(new User("Pasha", 11, "100")));
        assertThat(userService.findAll().length).isEqualTo(1);
        given(userDao.delete("100"))
                .willReturn(UserDB.getInstance().delete("100"));
        assertThat(userService.findAll().length).isEqualTo(0);
    }

    @Test
    void deleteUserWithoutIdFalse(){
        given(userDao.deleteWithoutId())
                .willReturn(UserDB.getInstance().deleteWithoutId());
        assertThat(userService.findAll().length).isEqualTo(0);
        assertThat(userService.deleteWithoutId()).isFalse();
    }

    @Test
    void deleteUserWithoutIdTrue() {
        given(userDao.create(new User()))
                .willReturn(UserDB.getInstance().create(new User("Pasha", 11)));
        assertThat(userService.findAll().length).isEqualTo(1);
        given(userDao.deleteWithoutId())
                .willReturn(UserDB.getInstance().deleteWithoutId());
        assertThat(userService.findAll().length).isEqualTo(0);
    }
}
