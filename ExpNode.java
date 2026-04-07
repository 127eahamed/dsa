public class ExpNode {
    private MathSymbol value;
    private ExpNode left, right;

    public ExpNode(String number) {
        this.value = new MathSymbol(Double.parseDouble(number));
    }

    public ExpNode(String operation, ExpNode left, ExpNode right) {
        this.value = new MathSymbol(operation);
        this.left = left;
        this.right = right;
    }

    public MathSymbol getValue() {
        return this.value;
    }

    public void setValue(MathSymbol newValue) {
        this.value = newValue;
    }

    public ExpNode getLeft() {
        return this.left;
    }

    public void setLeft(ExpNode newLeft) {
        this.left = newLeft;
    }

    public ExpNode getRight() {
        return this.right;
    }

    public void setRight(ExpNode newRight) {
        this.right = newRight;
    }
}