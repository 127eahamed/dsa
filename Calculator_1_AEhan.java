import java.util.ArrayList;
import java.util.Stack;

public class Calculator_1_AEhan implements Calculator2 {
    public Double calculate(ArrayList<MathSymbol> postfix) {
        Stack<Double> stack = new Stack<Double>();
        for (MathSymbol element : postfix) {
            if (element.isNumber()) {
                stack.push(element.getValue());
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();
                stack.push(element.compute(num1, num2));
            }
        }
        return stack.pop();
    }

    // public ExpNode buildTree(String expression) {
    //     int parentheses = 0;
    //     for (int i = expression.length() - 1; i >= 0; i--) {
    //         char current = expression.charAt(i);
    //         if (current == ')') {
    //             parentheses++;
    //         } else if (current == '(' && parentheses == 0) {
    //             throw new IllegalArgumentException("Attempting to close an unopened parenthesis");
    //         } else if (current == '(') {
    //             parentheses--;
    //         }
    //     }
    // }

    // public ArrayList<MathSymbol> postfix(ExpNode current) {
    //     ArrayList<MathSymbol> result = new ArrayList<MathSymbol>();
    //     if (current.getLeft() != null) {
    //         result.addAll(postfix(current.getLeft()));
    //     }
    //     if (current.getRight() != null) {
    //         result.addAll(postfix(current.getRight()));
    //     }
    //     result.add(current.getValue());
    //     return result;
    // }
}
