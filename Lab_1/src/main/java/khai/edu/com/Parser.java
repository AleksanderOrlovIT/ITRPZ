package khai.edu.com;

import java.util.Stack;

public class Parser {

    public double evalPostfix(String postfixExp){

        int index = 0;
        Stack<Double> arr = new Stack<Double>();
        double result = 0;

        for(int i = 0; i < postfixExp.length(); i++)
        {
            char c = postfixExp.charAt(i);
            if(c == ' ')
                continue;
            else if(Character.isDigit(c))
            {
                double x = 0.0;
                boolean check = true;
                while(Character.isDigit(c) || c == '.')
                {
                    if(c != '.' && check == true){
                        x = x*10 + (double)(c-'0');
                        i++;
                        c = postfixExp.charAt(i);
                    }
                    else{
                        check = false;
                        x = x + 0.1 + (double)(c-'0')/10;
                        i++;
                        c = postfixExp.charAt(i);
                    }
                }
                i--;
                arr.push(x);
            }
            else
            {
                double val1 = arr.pop();
                double val2 = arr.pop();
                switch(c)
                {
                    case '+':
                        arr.push(addition(val2,val1));
                        break;
                    case '-':
                        arr.push(subtraction(val2,val1));
                        break;
                    case '/':
                        arr.push(division(val2,val1));
                        break;
                    case '*':
                        arr.push(multiplication(val2, val1));
                        break;
                    default:
                        throw new ArithmeticException();
                }
            }
        }
        return arr.pop();
    }

    public String infixToPostfix(String exp){
        String result = "";
        Stack<Character> arr = new Stack<>();
        for (int i = 0; i <exp.length() ; i++) {
            char c = exp.charAt(i);
            if(precedence(c)>0){
                while(arr.isEmpty()==false && precedence(arr.peek())>=precedence(c)){
                    result += arr.pop();
                }
                result += ' ';
                arr.push(c);
            }else if(c==')'){
                char x = arr.pop();
                while(x!='('){
                    result += x;
                    x = arr.pop();
                }
            }else if(c=='('){
                arr.push(c);
            }else{
                result += c;
            }
        }
        for (int i = 0; i <=arr.size() ; i++) {
            result += arr.pop();
        }
        return result;
    }

    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    private double division (double value1, double value2) {
        if (value2 == 0) return Double.POSITIVE_INFINITY;
        else return value1/value2;
    }
    private double addition (double value1, double value2) {
        return value1 + value2;
    }
    private double multiplication (double value1, double value2) {
        return value1 * value2;
    }
    private double subtraction (double value1, double value2) {
        return value1 - value2;
    }

}