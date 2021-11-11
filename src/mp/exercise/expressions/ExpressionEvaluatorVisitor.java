package mp.exercise.expressions;

public class ExpressionEvaluatorVisitor implements ExpressionVisitor<Object> {

  @Override
  public Object visitConstant(Constant c) {
    return c.getConstantValue();
  }

  @Override
  public Object visitSum(Sum s) {
    return (Integer) evalLeft(s) + (Integer) evalRight(s);
  }

  @Override
  public Object visitMultiplication(Multiplication m) {
    return (Integer) evalLeft(m) * (Integer) evalRight(m);
  }

  @Override
  public Object visitEqual(Equal e) {
    return evalLeft(e).equals(evalRight(e));
  }

  private Object evalRight(BinaryExpression exp) {
    return exp.getRight().accept(this);
  }

  private Object evalLeft(BinaryExpression exp) {
    return exp.getLeft().accept(this);
  }
}
