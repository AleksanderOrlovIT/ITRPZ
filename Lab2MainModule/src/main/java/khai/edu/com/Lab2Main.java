package khai.edu.com;

import java.util.Scanner;
public class Lab2Main{
    public static void main(String[] args) {
        int decision = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Please press any number if you want to start the program or press 0 if you want to leave");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Wrong input, try again");
            }
            decision = sc.nextInt();
            switch (decision) {
                case 0:
                    break;
                case 1:
                    Main.main(args);
            }
            System.out.println("Everything is good");
            break;
        }
    }
}