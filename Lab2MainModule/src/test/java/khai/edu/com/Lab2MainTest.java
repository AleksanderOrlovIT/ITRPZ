package khai.edu.com;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class Lab2MainTest {

    @Test
    void makeDecision() {
        String[] arg1 = {"arg1"};
        Assertions.assertEquals(false, Lab2Main.makeDecision(arg1, "0"));
    }
}