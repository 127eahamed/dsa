public class Recursion_1_AEhan {
    public static void strictlyIncreasingDigits(int digits) {
        if (digits > 9) {
            System.out.println("Strictly increasing numbers cannot exceed 9 digits");
            return;
        }

        printNumbers((int) Math.pow(10, digits), digits);
    }
    public static void printNumbers(int number, int digits) {
        if (number >= (10 * (digits + 1))) {
            return;
        }

        System.out.println(nextNumber(number, digits));
        printNumbers(number + 1, digits);
    }
    public static int nextNumber(int number, int digits) {
        if (areDigitsIncreasing(number)) {
            return number;
        } else {
            return nextNumber(number + 1, digits);
        }
    }
    public static boolean areDigitsIncreasing(int number) {
        String digitsString = "" + number;
        for (int index = 0; index < digitsString.length() - 1; index++) {
            int currentDigit = Integer.parseInt(
                    digitsString.substring(index, index + 1)
            );
            int nextDigit = Integer.parseInt(
                    digitsString.substring(index + 1, index + 2)
            );
            if (!(nextDigit > currentDigit)) {
                return false;
            }
        }
        return true;
    }
}
