import java.util.Stack;
public class FP1_1_AEhan {
    public static boolean wrapped(String str) {
        String opening = "{[<(";
        String closing = "}]>)";
        Stack<Integer> openIndices = new Stack<Integer>();
        for (int index = 0; index < str.length(); index++) {
            int openIndex = opening.indexOf(str.charAt(index));
            int closeIndex = closing.indexOf(str.charAt(index));
            if (openIndex >= 0) {
                openIndices.push(openIndex);
            } else if (closeIndex >= 0 && (openIndices.empty() || openIndices.pop() != closeIndex)) {
                return false;
            }
        }
        return openIndices.empty();
    }
}
