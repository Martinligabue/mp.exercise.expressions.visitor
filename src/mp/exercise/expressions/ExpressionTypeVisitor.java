package mp.exercise.expressions;

public class ExpressionTypeVisitor {
    public void visit(Sum e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
    }

    public void visit(Multiplication e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
    }

    public void visit(Constant e) {
    }

    public void visit(Difference e) {
        e.getLeft().accept(this);
        e.getRight().accept(this);
    }

}
