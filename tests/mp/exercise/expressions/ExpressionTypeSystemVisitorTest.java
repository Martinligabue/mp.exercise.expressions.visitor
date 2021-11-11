package mp.exercise.expressions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTypeSystemVisitorTest {

    @Test
    public void testConstantType() {
        assertEquals(Integer.class,
            new Constant(10)
            .accept(new ExpressionTypeSystemVisitor()));
        assertEquals(Boolean.class,
            new Constant(true)
            .accept(new ExpressionTypeSystemVisitor()));
        assertEquals(String.class,
            new Constant("Hello")
            .accept(new ExpressionTypeSystemVisitor()));
    }

    @Test
    public void testUnexpectedType() {
        TypeSystemException thrown = assertThrows(TypeSystemException.class,
            () -> new Constant(10.1)
                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Unexpected type Double",
            thrown.getMessage());
    }

    @Test
    public void testEqualType() {
        assertEquals(Boolean.class,
            new Equal(new Constant(1), new Constant(2))
            .accept(new ExpressionTypeSystemVisitor()));
    }

    @Test
    public void testEqualIncompatibleTypes() {
        TypeSystemException thrown = assertThrows(TypeSystemException.class,
            () -> new Equal(new Constant(1), new Constant("hello"))
                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Incompatible types Integer and String",
            thrown.getMessage());
    }

    @Test
    public void testSumType() {
        assertEquals(Integer.class,
            new Sum(new Constant(1), new Constant(2))
            .accept(new ExpressionTypeSystemVisitor()));
    }

    @Test
    public void testSumNonIntegerLeftType() {
        TypeSystemException thrown = assertThrows(TypeSystemException.class,
            () -> new Sum(new Constant("hello"), new Constant(10))
                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected Integer but was String",
            thrown.getMessage());
    }

    @Test
    public void testSumNonIntegerRightType() {
        TypeSystemException thrown = assertThrows(TypeSystemException.class,
            () -> new Sum(new Constant(10), new Constant(true))
                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected Integer but was Boolean",
            thrown.getMessage());
    }

    @Test
    public void testMultiplicationType() {
        assertEquals(Integer.class,
            new Multiplication(new Constant(1), new Constant(2))
            .accept(new ExpressionTypeSystemVisitor()));
    }

    @Test
    public void testMultiplicationNonIntegerLeftType() {
        TypeSystemException thrown = assertThrows(TypeSystemException.class,
            () -> new Multiplication(new Constant("hello"), new Constant(10))
                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected Integer but was String",
            thrown.getMessage());
    }

    @Test
    public void testMultiplicationNonIntegerRightType() {
        TypeSystemException thrown = assertThrows(TypeSystemException.class,
            () -> new Multiplication(new Constant(10), new Constant(true))
                .accept(new ExpressionTypeSystemVisitor()));
        assertEquals("Expected Integer but was Boolean",
            thrown.getMessage());
    }

    @Test
    public void testTypeOfComplexExpression() {
        assertEquals(Boolean.class,
            new Equal(
                new Sum(new Constant(1), new Constant(2)),
                new Multiplication(
                    new Sum(new Constant(6), new Constant(2)),
                    new Multiplication(new Constant(6), new Constant(2)))
            )
            .accept(new ExpressionTypeSystemVisitor()));
    }
}
