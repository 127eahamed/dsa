//package DSA.GivenFiles.Unit8;

public interface Calculator3 {
    /**
     * Create the expression tree, find the postfix expression, then calculate
     * @param expression The expression to calculate
     * @return the result of the calculation
     * @see Calculator1#buildTree
     * @see Calculator1#postfix
     * @see Calculator2#calculate
     */
    public Double calculate(String expression);
}