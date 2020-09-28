package Duke;

/**
 * The Duke programme allows users to store their tasks into three different categories
 * Event, To Do and Deadline
 * Users can list out their tasks in the list in order
 * Users can mark a particular task as done as well as delete it
 * Users can also find relevant tasks by using a keyword
 *
 * @author AliciaHo
 * @version 1.0
 * @since 2020-9-29
 */
public class Duke {

    private Storage storage = new Storage();
    private TaskList tasks;
    private Ui ui;

    /**
     * Used to filter the ArrayList list by the keyword inputted by the user.
     *
     */
    public Duke() {
        ui = new Ui();
        storage.createTextFile();
        tasks = new TaskList(storage.readTextFile(0));
    }

    /**
     * Used to run the main program of Duke
     * where a welcome message is first showed
     * Afterwards, input is taken from the user
     * When user inputted bye, a exit message is shown
     */
    public void run() {
        String userInput;
        int noOfTask = 0;
        ui.showWelcomeMessage();
        do {
            userInput = ui.getUserCommand();
            noOfTask = Parser.parseCommand(userInput, noOfTask);
            storage.updateTextFile();
        } while (!userInput.equals("bye"));
        ui.showExitMessage();
    }

    /**
     * Initialise duke
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}
