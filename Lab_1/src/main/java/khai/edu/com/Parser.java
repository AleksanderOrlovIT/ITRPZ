package khai.edu.com;

public class Parser implements MathOperations{

    int pos = -1, ch;
    final String str;
    public Parser ( String str) {
        this.str = str;
    }

    public void nextChar() {
        ch = (++pos < str.length()) ? str.charAt(pos) : -1;
    }

    public boolean eat(int charToEat) {
        while (ch == ' ') nextChar();
        if (ch == charToEat) {
            nextChar();
            return true;
        }
        return false;
    }

    public double parse() {
        nextChar();
        double x = parseExpression();
        if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
        return x;
    }

    public double parseExpression() {
        double x = parseTerm();
        for (;;) {
            if      (eat('+')) x += parseTerm();
            else if (eat('-')) x -= parseTerm();
            else return x;
        }
    }

    public double parseTerm() {
        double x = parseFactor();
        for (;;) {
            if      (eat('*')) x *= parseFactor();
            else if (eat('/')) x /= parseFactor();
            else return x;
        }
    }

    public double parseFactor() {
        if (eat('+')) return parseFactor();
        if (eat('-')) return -parseFactor();

        double x;
        int startPos = this.pos;
        if (eat('(')) {
            x = parseExpression();
            eat(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') {
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(str.substring(startPos, this.pos));
        } else if (ch >= 'a' && ch <= 'z') {
            while (ch >= 'a' && ch <= 'z') nextChar();
            String func = str.substring(startPos, this.pos);
            x = parseFactor();
        } else {
            throw new RuntimeException("Unexpected: " + (char)ch);
        }
        return x;
    }
}