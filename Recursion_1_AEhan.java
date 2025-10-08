import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_1_AEhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
Choose an assignment:
1: Strictly Increasing Digits Generator
2: m-th Summation of the First n Natural Numbers
3: Generate Binary Strings Without Consecutive 1's
4: Print n-Digit Binary Numbers with Equal Sum in Left and Right Halves
5: Calculate Maximum Number of Chocolates You Can Eat

Pick assignment to run (number or name):\s""");
        String input = sc.nextLine().toLowerCase();
        if (
            (input.contains("1") && !(
                input.contains("consecutive") || input.contains("1's")
            )) ||
            input.contains("strictly") ||
            input.contains("increasing")
        ) {
            System.out.print("""

Assignment 1: Strictly Increasing Digits Generator

Enter number of digits:\s"""
            );
            strictlyIncreasingDigits(sc.nextInt());
        } else if (
            input.contains("2") ||
            input.contains("summation") ||
            input.contains("natural")
        ) {
            System.out.print("""

Assignment 2: m-th Summation of the First n Natural Numbers

Enter n, number of digits:\s"""
            );
        } else if (
            input.contains("3") ||
            input.contains("without") ||
            input.contains("consecutive") ||
            input.contains("1's")
        ) {
            System.out.print("""

Assignment 3: Generate Binary Strings Without Consecutive 1's

Enter k, size:\s"""
            );
            genBinaryStringsWithoutConsecutive1s(sc.nextInt());
        }
    }

    public static void strictlyIncreasingDigits(int digits) {
        if (digits > 9) {
            System.out.println("Strictly increasing numbers cannot exceed 9 digits");
            return;
        }

        printNumbers((int) Math.pow(10, digits), digits);
    }
    public static void printNumbers(int number, int digits) {
        if (number >= (Math.pow(10, digits + 1))) {
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

    public static void genBinaryStringsWithoutConsecutive1s(int k) {
        ArrayList<String> startingStrings = new ArrayList<>();
        startingStrings.add("0");
        startingStrings.add("1");
        for (String str : binaryStringsWithoutConsecutive1s(startingStrings, k)) {
            System.out.println(str);
        }
    }
    public static ArrayList<String> binaryStringsWithoutConsecutive1s(
        ArrayList<String> strings, int k
    ) {
        ArrayList<String> newStrings = new ArrayList<String>();
        for (int index = 0; index < strings.size(); index++) {
            String str = strings.get(index);
            if (str.length() >= k) {
                return strings;
            }

            if (str.charAt(str.length() - 1) == '1') {
                newStrings.add(index, str + "0");
            } else {
                newStrings.add(str + "0");
                newStrings.add(str + "1");
            }
        }
        return binaryStringsWithoutConsecutive1s(newStrings, k);
    }
}
