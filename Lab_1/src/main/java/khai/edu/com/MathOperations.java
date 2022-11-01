package khai.edu.com;

import java.math.BigDecimal;

    public interface MathOperations {
    void nextChar();
    boolean eat(int charToEat);
    double parse();
    double parseExpression();
    double parseTerm();
    double parseFactor();
}
