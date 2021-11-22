public class ExpressionInterpreter {
    public Object interpret(Expression expression) throws ExpressionInterpreterException {
        try {
            // ignore type result, as long as it's well-typed
            new ExpressionTypeSystem().computeType(expression);
            return new ExpressionEvaluator().eval(expression);
        } catch (TypeSystemException e) {
            throw new ExpressionInterpreterException("Expression not well-typed", e);
        }
    }
}
