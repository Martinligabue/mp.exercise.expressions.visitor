package mp.exercise.expressions;

public final class Constant implements Expression {

  private Object constantValue;

  public Constant(Object constantValue) {
    this.constantValue = constantValue;
  }

  public Object getConstantValue() {
    return constantValue;
  }

  @Override
  public <T> T accept(ExpressionVisitor<T> visitor) {
    return visitor.visitConstant(this);
  }
}
