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
            Parser parser = new Parser();
            try {
                System.out.println("Answer is: " + parser.evalPostfix(parser.infixToPostfix(sc.nextLine())));
            }
            catch (Exception e) {System.out.println(e);};
            sc.close();
        }
    }
}