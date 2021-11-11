package mp.exercise.expressions;

public final class Sum extends BinaryExpression {

    public Sum(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        // TODO Auto-generated method stub
        return visitor.visitSum(this);
    }

}
