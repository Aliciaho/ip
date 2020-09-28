package Duke;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * To configure the UI interface for the user
 * consists of a welcome message, reading the user input and a exit message
 */
public class Ui {
    private Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    /**
     * Initialise the scanner needed to scan the user's input
     */
    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Returns the user input
     */
    public String getUserCommand() {
        String userInput = in.nextLine();
        return userInput;
    }

    /**
     * Print the welcome message and prompt the user to input a command
     */
    public void showWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke.Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * Print the exit message to show the user that the program has ended
     */
    public void showExitMessage() {
        System.out.println("BYE BYE! SEE YOU NEXT TIME :3!");
    }


}
