public class MathSymbol {
    private final boolean isNumber;

    private final String operation;
    private final Double value;

    public MathSymbol(String operation) {
        this.isNumber = false;
        this.operation = operation;
        this.value = null;
    }

    public MathSymbol(Double value) {
        this.isNumber = true;
        this.operation = null;
        this.value = value;
    }

    public Double compute(Double value1, Double value2) {
        return switch (operation) {
            case "+" -> value1 + value2;
            case "-" -> value1 - value2;
            case "*" -> value1 * value2;
            case "/" -> value1 / value2;
            case "^" -> Math.pow(value1, value2);
            default -> null;
        };
    }

    public boolean isNumber() {
        return isNumber;
    }

    public String getOperation() {
        return operation;
    }

    public Double getValue() {
        return value;
    }

    /**
     * Determines the position of the operator with less precedence     * @param op1 Operation 1 to compare
     * @param index1 Index of Operation 1
     * @param op2 Operation 2 to compare
     * @param index2 Index of Operation 2
     * @return rightmost index of operation with the least precedence
     */
    public static int leastPrecedence(String op1, int index1, String op2, int index2) {
        int precedence1 = getPrecedence(op1);
        int precedence2 = getPrecedence(op2);
        if(precedence1 < precedence2)
            return index1;
        else if(precedence2 < precedence1)
            return index2;
        else
            return Integer.max(index1, index2);
    }

    /**
     * Returns a value corresponding with level of precedence of a given operation,
     * Operations range from 0-2, Non-operations will result in -1
     * Precondition: operation is not null
     */
    private static int getPrecedence(String operation) {
        if(operation.equals("+") || operation.equals("-"))
            return 0;
        else if(operation.equals("*") || operation.equals("/") || operation.equals("%"))
            return 1;
        else if(operation.equals("^"))
            return 2;
        else return -1;
    }

    public static boolean isOperation(String str) {
        return getPrecedence(str) > -1;

    }

    public String toString() {
        if(isNumber)
            return ""+ value;
        else return operation;
    }
}
