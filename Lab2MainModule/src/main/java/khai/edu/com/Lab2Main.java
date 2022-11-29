package khai.edu.com;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab2Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Press 1 to start lab1\n" +
                    "Press 0 to stop the program");
            flag = makeDecision(args, sc.nextLine());
        }
    }

    public static boolean makeDecision(String[] args, String decision) {
        switch (decision) {
            case "1":
                Main.main(args);
                break;
            default:
                return false;
        }
        return true;
    }
}