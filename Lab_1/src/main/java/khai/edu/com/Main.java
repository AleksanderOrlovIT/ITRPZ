package khai.edu.com;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        BigDecimal n = new BigDecimal("0");
        String temp = "0.0000000001";
        if(isBigDecimal(temp)){
         n = new BigDecimal(temp);
        }
        n = n.multiply(new BigDecimal("10000000000"));
        System.out.println(n);
    }

    public static BigDecimal formatBigDecimal(String value) {
        if (value == null) {
            return null;
        }

        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isBigDecimal(String value) {
        return (formatBigDecimal(value) != null);
    }
}