package mp.exercise.expressions;

import java.util.Arrays;
import java.util.List;

public class ExpressionTypeSystemVisitor implements ExpressionVisitor<Class<?>> {

    private List<Class<?>> expectedTypes =
        Arrays.asList(Integer.class, String.class, Boolean.class);

    @Override
    public Class<?> visitConstant(Constant c) {
        final Class<?> type = c.getConstantValue().getClass();
        if (!expectedTypes.contains(type))
            throw new TypeSystemException
                ("Unexpected type " + type.getSimpleName());
        return type;
    }

    @Override
    public Class<?> visitSum(Sum s) {
        Class<?> leftType = leftType(s);
        Class<?> rightType = rightType(s);
        checkIntegerType(leftType);
        checkIntegerType(rightType);
        return Integer.class;
    }

    @Override
    public Class<?> visitMultiplication(Multiplication m) {
        Class<?> leftType = leftType(m);
        Class<?> rightType = rightType(m);
        checkIntegerType(leftType);
        checkIntegerType(rightType);
        return Integer.class;
    }

    private void checkIntegerType(Class<?> type) {
        if (type != Integer.class)
            throw new TypeSystemException
                ("Expected Integer but was " +
                    type.getSimpleName());
    }

    @Override
    public Class<?> visitEqual(Equal e) {
        Class<?> leftType = leftType(e);
        Class<?> rightType = rightType(e);
        if (leftType != rightType)
            throw new TypeSystemException
                (String.format("Incompatible types %s and %s",
                    leftType.getSimpleName(),
                    rightType.getSimpleName()));
        return Boolean.class;
    }

    private Class<?> leftType(BinaryExpression e) {
        return e.getLeft().accept(this);
    }

    private Class<?> rightType(BinaryExpression e) {
        return e.getRight().accept(this);
    }

}
