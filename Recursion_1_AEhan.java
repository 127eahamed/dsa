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
    public static int mthSummationOfFirstNNaturalNums(int n, int m) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += summationOfFirstNNaturalNums(n)
        }
        return sum;
    }
    public static int summationOfFirstNNaturalNums(int n) {
        int sum = 0;
        for (int naturalNum = 1; naturalNum <= n; naturalNum++) {
            sum += naturalNum;
        }
        return sum;
    }

    /*
     * Assignment 3: Generate Binary Strings Without Consecutive 1's
     * */
    public static ArrayList<String> genBinaryStringsWithoutConsecutive1s(int k) {
        ArrayList<String> result = new ArrayList<>();
        nextBinaryStringWithoutConsecutive1s(result, "0", k);
        nextBinaryStringWithoutConsecutive1s(result, "1", k);
        return result;
    }
    public static void nextBinaryStringWithoutConsecutive1s(
        ArrayList<String> strings, String binaryString, int k
    ) {
        if (binaryString.length() >= k) {
            strings.add(binaryString);
            return;
        }

        if (binaryString.endsWith("1")) {
            nextBinaryStringWithoutConsecutive1s(strings, binaryString + "0", k);
        } else {
            nextBinaryStringWithoutConsecutive1s(strings, binaryString + "0", k);
            nextBinaryStringWithoutConsecutive1s(strings, binaryString + "1", k);
        }
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
    public static int calcMaxNumOfChocolates(double money, double price, int wrap) {
        if (money < price) {
            return 0;
        } else {
            int chocolates = (int) (money / price);
            money -= chocolates * price;
            chocolates += chocolates / wrap;
            return chocolates + calcMaxNumOfChocolates(money, price, wrap);
        }
    }

    /*
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
            for (String str : genBinaryStringsWithoutConsecutive1s(sc.nextInt())) {
                System.out.println(str);
            }
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
        } else if (
            input.contains("5") ||
            input.contains("chocolate")
        ) {
            System.out.print(
                "\n" +
                "Assignment 5: Calculate Maximum Number of Chocolates You Can Eat\n" +
                "\n" +
                "Enter total amount of money you have to buy chocolates: $"
            );
            double money = sc.nextDouble();
            System.out.print(
                "\n" +
                "Enter the price of one chocolate: $"
            );
            double price = sc.nextDouble();
            System.out.print(
                "\n" +
                "Enter number of wrappers needed to exchange for one additional chocolate: "
            );
            int wrap = sc.nextInt();
            System.out.println(
                "Maximum number of chocolates: " + calcMaxNumOfChocolates(money, price, wrap)
            );
        }
    }
}
