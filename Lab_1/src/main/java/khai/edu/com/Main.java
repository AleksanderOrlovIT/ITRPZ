package khai.edu.com;

import khai.edu.com.Parser;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser(sc.nextLine()).parse();
    }
}