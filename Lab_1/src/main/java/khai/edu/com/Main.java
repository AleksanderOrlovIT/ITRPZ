package khai.edu.com;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(
                    "Please press anything if you want to start the program or press 0 if you want to leave");
            if(sc.nextLine().equals("0")) break;
            System.out.println("PLease input your math expression to count it");
            try {
                Parser parser = new Parser(sc.nextLine());
                System.out.println("Answear is: " + parser.parse());
            }
            catch (Exception e) {System.out.println(e);};
        }
    }
}