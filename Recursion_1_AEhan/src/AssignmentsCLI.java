import java.util.Scanner;

public class AssignmentsCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
Choose an assignment:
1: Strictly Increasing Digits Generator
2: m-th Summation of the First n Natural Numbers
3: Generate Binary Strings Without Consecutive 1's
4: Print n-Digit Binary Numbers with Equal Sum in Left and Right Halves
5: Calculate Maximum Number of Chocolates You Can Eat

Pick an assignment to run: (Number or Name)
""");
        String input = sc.nextLine().toLowerCase();
        if (
            (input.contains("1") && !input.contains("consecutive")) ||
            input.contains("strictly"))
    }
}
