package khai.edu.com;

import java.math.BigDecimal;

public interface MathOperations {
    double calc(final String str);
    void nextChar();
    boolean eat(int charToEat);
    double parse();
    double parseExpression();
    double parseTerm();

    double parseFactor();
}
