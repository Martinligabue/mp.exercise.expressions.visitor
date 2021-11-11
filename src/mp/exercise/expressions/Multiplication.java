package mp.exercise.expressions;

public final class Multiplication extends BinaryExpression {

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitMultiplication(this);
    }

}
