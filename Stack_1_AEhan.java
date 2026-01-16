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
        if (document.isEmpty()) {
            return;
        }
        undos.push(document.charAt(document.length() - 1));
        document = document.substring(0, document.length() - 1);
    }

    public void redo() {
        if (undos.empty()) {
            return;
        }
        document = document + undos.pop();
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
                System.out.println("The command WRITE needs to be followed by a character to write");
                continue;
            }
            String commandAlphaNumeric = command.replaceAll("[^a-zA-Z0-9]", "");
            if (commandAlphaNumeric.equalsIgnoreCase("READ")) {
                System.out.println(textEditor.read());
                continue;
            }
            if (commandAlphaNumeric.equalsIgnoreCase("UNDO")) {
                textEditor.undo();
                continue;
            }
            if (commandAlphaNumeric.equalsIgnoreCase("REDO")) {
                textEditor.redo();
                continue;
            }
            if (
                commandAlphaNumeric.equalsIgnoreCase("EXIT") ||
                commandAlphaNumeric.equalsIgnoreCase("QUIT") ||
                commandAlphaNumeric.equalsIgnoreCase("q")
            ) {
                System.exit(0);
            }
            System.out.println(
"""
Unknown command :(

Valid commands are:
WRITE X
READ
UNDO
REDO
EXIT
QUIT"""
            );
        }
    }
}
