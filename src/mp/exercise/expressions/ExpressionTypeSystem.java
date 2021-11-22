package mp.exercise.expressions;

public class ExpressionTypeSystem {

    public void computeType(Expression expression) {
        expression.accept(new ExpressionTypeVisitor());
    }

}
