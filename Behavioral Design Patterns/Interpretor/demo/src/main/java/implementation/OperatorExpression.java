package implementation;

public class OperatorExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;
    char operator;

    public OperatorExpression(char operator, Expression leftExpression, Expression rightExpression) {
        this.operator = operator;   
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        switch (operator) {
            case '+':
                return leftExpression.interpret() + rightExpression.interpret();
            case '-':
                return leftExpression.interpret() - rightExpression.interpret();
            case '*':
                return leftExpression.interpret() * rightExpression.interpret();
            case '/':
                return leftExpression.interpret() / rightExpression.interpret();
            default:
                return 0;
        }
    }
}
