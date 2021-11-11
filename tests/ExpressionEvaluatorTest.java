
import org.junit.*;

import mp.exercise.expressions.Constant;
import mp.exercise.expressions.Equal;
import mp.exercise.expressions.ExpressionEvaluatorVisitor;
import mp.exercise.expressions.ExpressionVisitor;

public class ExpressionEvaluatorTest {
    @Test
    public void testEvalConstant() {

        assertEquals(10, new Constant(10).accept(new ExpressionVisitor()));
        assertEquals(true, new Constant(true).accept(new ExpressionVisitor()));
        assertEquals("test", new Constant("test").accept(new ExpressionVisitor()));
    }

    @Test
    public void testEvalOfConstants(){
        assertEquals(true, new Equal(new Constant(10), new Constant(10)
            .accept(new ExpressionEvaluatorVisitor())));
    }

}
