package Duke;

public class Duke {

    private Storage storage = new Storage();
    private TaskList tasks;
    private Ui ui;

    public Duke() {
        ui = new Ui();
        storage.createTextFile();
        tasks = new TaskList(storage.readTextFile(0));
    }

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

    public static void main(String[] args) {
        new Duke().run();
    }
}
