package mp.exercise.expressions;

public abstract class BinaryExpression implements Expression {

  private Expression left;
  private Expression right;

  protected BinaryExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  public final Expression getLeft() {
    return left;
  }

  public final Expression getRight() {
    return right;
  }
}
