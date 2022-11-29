package khai.edu.com.controller;

import khai.edu.com.entity.User;
import khai.edu.com.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option");
        try {
            boolean flag;
            do {
                runNavigation();
                flag = crud(reader.readLine(), reader);
            }while (flag);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create user, please enter 1");
        System.out.println("if you want update user, please enter 2");
        System.out.println("if you want delete user, please enter 3");
        System.out.println("if you want findById user, please enter 4");
        System.out.println("if you want findAll user, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private boolean crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findById(reader); break;
            case "5" : findAll(reader); break;
            case "0" : return false;
            default:
                System.out.println("Wrong input please try again");
        }
        return true;
    }

    private void create(BufferedReader reader) {
        System.out.println("UserController.create");
        try {
            User user = new User();
            System.out.println("Please, enter your name");
            user.setName(reader.readLine());
            System.out.println("Please, enter your age");
            while (true) {
                try {
                    user.setAge(Integer.parseInt(reader.readLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You can type only numbers. PLease try again");
                }
            }
            UserService.create(user);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("UserController.update");
        try {
            User user = new User();
            System.out.println("Please, enter id");
            user.setId(reader.readLine());
            System.out.println("Please, enter your name");
            user.setName(reader.readLine());
            System.out.println("Please, enter your age");
            while (true) {
                try {
                    user.setAge(Integer.parseInt(reader.readLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You can type only numbers. PLease try again");
                }
            }
            UserService.update(user);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("UserController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            if(UserService.findAll().length != 0 || UserService.findById(id) != null) {
                UserService.delete(id);
            }
            else System.out.println("No user with such id");
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("UserController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            if(UserService.findAll().length != 0) {
                User user = UserService.findById(id);
                if(user == null) System.out.println("There is no user with such id");
                else System.out.println("user = " + user);
            }
            else System.out.println("Users empty");
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("UserController.findAll");
        User[] users = UserService.findAll();
        if (users != null && users.length != 0) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("users empty");
        }
    }
}
