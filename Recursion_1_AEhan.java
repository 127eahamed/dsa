import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_1_AEhan {
    /*
     * Assignment 1: Recursive Strictly Increasing Digits Generator
     * */
    public static void strictlyIncreasingDigits(int n) {
        if (n > 9) {
            return;
        }

        printNumbers((int) Math.pow(10, n), n);
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

    /*
     * Assignment 2: mth Summation of the First n Natural Numbers
     * */


    /*
     * Assignment 3: Generate Binary Strings Without Consecutive 1's
     * */
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

    /*
     * Assignment 4: Print n-Digit Binary Numbers with Equal Sum in Left and Right Halves
     * */
    public static void printNDigitBinaryNumsWithEqualSum(int n) {
        printNDigitBinaryNumsWithEqualSumFromString("", n);
    }
    public static void printNDigitBinaryNumsWithEqualSumFromString(
        String binaryString, int n
    ) {
        if (binaryString.length() == n) {
            char[] leftHalf = binaryString.substring(
                0, n / 2
            ).toCharArray();
            char[] rightHalf = binaryString.substring(
                (int) (((double) n / 2) + 0.5)
            ).toCharArray();
            int leftSum = 0;
            int rightSum = 0;
            for (char c : leftHalf) {
                if (c == '1') {
                    leftSum++;
                }
            }
            for (char c : rightHalf) {
                if (c == '1') {
                    rightSum++;
                }
            }
            if (leftSum == rightSum) {
                System.out.println(binaryString);
            }
        } else {
            printNDigitBinaryNumsWithEqualSumFromString(
                binaryString + "0",
                n
            );
            printNDigitBinaryNumsWithEqualSumFromString(
                binaryString + "1",
                n
            );
        }
    }


    /*
     * Assignment 5: Calculate Maximum Number of Chocolates You Can Eat
     * */


    /**
     * Main Method to Test/Run Each Assignment
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(
            "Choose an assignment:\n" +
            "1: Strictly Increasing Digits Generator\n" +
            "2: m-th Summation of the First n Natural Numbers\n" +
            "3: Generate Binary Strings Without Consecutive 1's\n" +
            "4: Print n-Digit Binary Numbers with Equal Sum in Left and Right Halves\n"+
            "5: Calculate Maximum Number of Chocolates You Can Eat\n"+
            "\n" +
            "Pick assignment to run (number or name): "
        );
        String input = sc.nextLine().toLowerCase();
        if (
            (input.contains("1") && !(
                input.contains("consecutive") || input.contains("1's")
            )) ||
            input.contains("strictly") ||
            input.contains("increasing")
        ) {
            System.out.print(
                "\n" +
                "Assignment 1: Strictly Increasing Digits Generator\n" +
                "\n" +
                "Enter number of digits: "
            );
            strictlyIncreasingDigits(sc.nextInt());
        } else if (
            input.contains("2") ||
            input.contains("summation") ||
            input.contains("natural")
        ) {
            System.out.print(
                "\n" +
                "Assignment 2: m-th Summation of the First n Natural Numbers\n" +
                "\n" +
                "Enter number of digits, n: "
            );
        } else if (
            input.contains("3") ||
            input.contains("without") ||
            input.contains("consecutive") ||
            input.contains("1's")
        ) {
            System.out.print(
                "\n" +
                "Assignment 3: Generate Binary Strings Without Consecutive 1's\n" +
                "\n" +
                "Enter size/length, k: "
            );
            genBinaryStringsWithoutConsecutive1s(sc.nextInt());
        } else if (
            input.contains("4") ||
            input.contains("equal") ||
            input.contains("halves")
        ) {
            System.out.print(
                "\n" +
                "Assignment 4: Print n-Digit Binary Numbers with Equal Sum in Left and Right Halves\n" +
                "\n" +
                "Enter size/length, n: "
            );
            printNDigitBinaryNumsWithEqualSum(sc.nextInt());
        }
    }
}
