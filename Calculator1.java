import java.util.ArrayList;

public interface Calculator1 {
    /**
     * Takes in an infix expression and recursively builds the tree, returning the root of the tree
     * @param expression Takes in an infix expression as a String
     * @return the root of the tree
     * @see ExpNode ExpNode's single parameter constructor is for numbers only, use the three parameter constructor for
     *      * any operations
     * @see MathSymbol#leastPrecedence(String, int, String, int) use MathSymbol's provided static leastPrecedence
     * function to determine which operations have the least precedence
     * @see MathSymbol#isOperation(String) use MathSymbol's provided static isOperation function to determine if a
     * given math symbol is an operation
     */
    public ExpNode buildTree(String expression);

    /**
     * Takes in a ExpNode and performs post-order traversal to get postfix as an ArrayList
     * @param current a node to find the traversal from
     * @return the postfix expression but listed as an ArrayList
     */
    public ArrayList<MathSymbol> postfix(ExpNode current);
}