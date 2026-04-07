import java.util.ArrayList;

public interface Calculator2 {
    /**
     * Uses a Stack of Doubles to find the value of a postfix expression
     * @param postfix the postfix expression in the form of an ArrayList
     * @return the result after calculating
     */
    public Double calculate(ArrayList<MathSymbol> postfix);
}