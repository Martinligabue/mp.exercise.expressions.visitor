package mp.exercise.expressions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionEvaluatorVisitorTest {

    @Test
    public void testEvalConstant() {
        assertEquals(10,
            new Constant(10)
            .accept(new ExpressionEvaluatorVisitor()));
        assertEquals(true,
            new Constant(true)
            .accept(new ExpressionEvaluatorVisitor()));
        assertEquals("Hello",
            new Constant("Hello")
            .accept(new ExpressionEvaluatorVisitor()));
    }

    @Test
    public void testEvalEqualsTwoConstants() {
        assertEquals(true,
            new Equal(
                new Constant(10),
                new Constant(10)
            )
            .accept(new ExpressionEvaluatorVisitor()));
        assertEquals(false,
            new Equal(
                new Constant(1),
                new Constant(10)
            )
            .accept(new ExpressionEvaluatorVisitor()));
        assertEquals(false,
            new Equal(
                new Constant("hello"),
                new Constant(10)
            )
            .accept(new ExpressionEvaluatorVisitor()));
    }

    @Test
    public void testEvalEqualsTwoExpressions() {
        assertEquals(true,
            new Equal(
                new Sum(new Constant(10), new Constant(2)),
                new Multiplication(new Constant(6), new Constant(2))
            )
            .accept(new ExpressionEvaluatorVisitor()));
        assertEquals(false,
            new Equal(
                new Sum(new Constant(1), new Constant(2)),
                new Multiplication(new Constant(6), new Constant(2))
            )
            .accept(new ExpressionEvaluatorVisitor()));
    }

    @Test
    public void testEvalSumTwoIntegers() {
        assertEquals(15,
            new Sum(new Constant(5), new Constant(10))
            .accept(new ExpressionEvaluatorVisitor()));
    }

    @Test
    public void testEvalMultiplicationTwoIntegers() {
        assertEquals(15,
            new Multiplication(new Constant(5), new Constant(3))
            .accept(new ExpressionEvaluatorVisitor()));
    }

    @Test
    public void testEvalSumAndMultiplicationTwoIntegers() {
        assertEquals(16,
            new Multiplication(
                new Sum(new Constant(5), new Constant(3)),
                new Constant(2))
            .accept(new ExpressionEvaluatorVisitor()));
    }

    @Test
    public void testEvalSumNonIntegers() {
        ClassCastException thrown = assertThrows(ClassCastException.class,
            () -> new Sum(new Constant(5), new Constant("BANG!"))
                .accept(new ExpressionEvaluatorVisitor()));
        assertEquals("java.lang.String cannot be cast to java.lang.Integer",
            thrown.getMessage());
    }

    @Test
    public void testEvalMultiplicationNonIntegers() {
        ClassCastException thrown = assertThrows(ClassCastException.class,
            () -> new Multiplication(new Constant(false), new Constant(3))
                .accept(new ExpressionEvaluatorVisitor()));
        assertEquals("java.lang.Boolean cannot be cast to java.lang.Integer",
                thrown.getMessage());
    }

}
