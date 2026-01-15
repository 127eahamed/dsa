import java.util.Stack;
import java.util.Scanner;

public class Stack_1_AEhan {
    private String document = "";
    private Stack<Character> undos = new Stack<Character>();

    public String read() {
        return document;
    }

    public void write(char x) {
        document = document + x;
    }

    public void undo() {
    }

    public void redo() {

    }

    public static void main(String[] args) {
        Stack_1_AEhan textEditor = new Stack_1_AEhan();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter command: (WRITE X, READ, UNDO, REDO)");
        String command;
        while (true) {
            System.out.print("> ");
            command = scn.nextLine();
            if (command.toUpperCase().startsWith("WRITE ") && command.length() == 7) {
                textEditor.write(command.charAt(6));
                continue;
            } else if (command.toUpperCase().startsWith("WRITE")) {
                /* write command with no space */
                System.out.println("The command WRITE X needs to be followed by a character to write");
                continue;
            }
            if (command.toUpperCase().startsWith("READ")) {
                System.out.println(textEditor.read());
                continue;
            }
            if (command.toUpperCase().startsWith("UNDO")) {
                textEditor.undo();
                continue;
            }
            if (command.toUpperCase().startsWith("REDO")) {
                textEditor.redo();
                continue;
            }
            if (
                command.toUpperCase().startsWith("EXIT") ||
                command.toUpperCase().startsWith("QUIT") ||
                command.equalsIgnoreCase("q")
            ) {
                System.exit(0);
            }
        }
    }
}
