package khai.edu.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    public static String[] lines =
            {"1 * 2", "asd", "0.123 * 1000 - 100 + (1 * 4)", "1 - 2 + - 1 + 2 +- 1 * 0 + 2 - 1",
            "1000000000000000000000000000 * 1",
                    "0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000001 * 1",
            "1", "(1 + 9) * (1 + 9) / (40 - 20) + (100 - 50) - (1000 - (50 * 10 * 2))"};

    @Test
    public void main() {
        Parser parser = new Parser();
        Assertions.assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[0])), 2.0);
        System.out.println("First");

        /*Exception exception = assertThrows(RuntimeException.class, () -> {new Parser().evalPostfix(new Parser().infixToPostfix(lines[1]));});
        String expectedMessage = "Unexpected: \uFFFF";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("Second");*/

        parser = new Parser();
        assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[2])), 27.0);
        System.out.println("Third");

        parser = new Parser();
        assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[3])), 1.0);
        System.out.println("Fourth");

        parser = new Parser();
        assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[4])), 1.0E27);
        System.out.println("Fifth");

        parser = new Parser();
        assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[5])), 1.0E-85);
        System.out.println("Sixth");

        parser = new Parser();
        assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[6])), 1.0);
        System.out.println("Seventh");

        parser = new Parser();
        assertEquals(parser.evalPostfix(parser.infixToPostfix(lines[7])), 55.0);
        System.out.println("Last");
    }
}