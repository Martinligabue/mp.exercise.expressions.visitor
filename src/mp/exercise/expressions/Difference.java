package mp.exercise.expressions;

public class Difference extends BinaryExpression{

    public Difference(Expression left, Expression right) {
        super(left, right);
    }
    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visitDifference(this);
    }

}
