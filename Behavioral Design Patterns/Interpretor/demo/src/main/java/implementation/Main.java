/*
 * Hakan Gezginci
 * 
 * Interpreter Design Pattern
 * 
 * This pattern is used to define a language and provide an interpreter for it.
 * In this case, the language is a simple mathematical expression language.
 * For example, the expression "6324-+*" is interpreted as ((6 - 3) + 2) * 4.
 * 
 * Parser:
 * The Parser class is responsible for parsing the expression string and 
 * creating an expression tree. It uses the OperatorExpression and 
 * NumberExpression classes to represent the operators and numbers in the 
 * expression. A stack data structure is used to handle the operations and 
 * operands in the expression.
 * 
 * Interpreter:
 * The interpretation of the expression tree is performed by calling the 
 * interpret method on the Expression object. If the Expression object is an 
 * OperatorExpression, the interpret method performs the operation represented 
 * by the OperatorExpression object and returns the result. If the Expression 
 * object is a NumberExpression, the interpret method simply returns the number 
 * represented by the NumberExpression object.
 */



package implementation;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        String expressionString = "6324-+*";
        Expression expression = parser.parse(expressionString);
        System.out.println(expression.interpret());
    }
}