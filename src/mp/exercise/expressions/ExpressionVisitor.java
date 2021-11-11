package mp.exercise.expressions;

public interface ExpressionVisitor<Object> {
    T visitConstant(Constant c);

    T visitSum(Sum s);

    T visitMultiplication(Multiplication m);

    T visitEqual(Equal e);

}
