package implementation;

import java.util.Stack;

public class Parser {
    private Stack<Expression> stack;

    public Parser() {
        stack = new Stack<>();
    }

    public Expression parse(String expressionString) {

        for (int i = 0; i < expressionString.length(); i++) {
            char c = expressionString.charAt(i);

            if (isOperator(c)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = new OperatorExpression(c, leftExpression, rightExpression);
                stack.push(operator);
            } else if (Character.isDigit(c)) {
                stack.push(new NumberExpression(Character.getNumericValue(c)));
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        
        return stack.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }    
}
