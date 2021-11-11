package mp.exercise.expressions;

public class ExpressionEvaluatorVisitor implements ExpressionVisitor<T> {

    @Override
    public Object visitConstant(Constant c) {
        return c.getConstantValue();
    }

    @Override
    public Object visitSum(Sum s) {
        return null;
    }

    @Override
    public Object visitMultiplication(Multiplication m) {
        return null;
    }

    @Override
    public Object visitEqual(Equal e) {
        return e.getLeft()
            .accept(this)
            .equals(e.getRight()
                .accept(this));
    }

}
