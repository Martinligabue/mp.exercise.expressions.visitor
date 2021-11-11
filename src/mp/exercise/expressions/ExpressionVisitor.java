package mp.exercise.expressions;

public interface ExpressionVisitor<T> {
  T visitConstant(Constant c);

  T visitSum(Sum s);

  T visitMultiplication(Multiplication m);

  T visitEqual(Equal e);
}
