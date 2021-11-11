package mp.exercise.expressions;

public interface Expression {
  <T> T accept(ExpressionVisitor<T> visitor);
}
