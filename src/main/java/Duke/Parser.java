package Duke;

import java.util.ArrayList;
import Duke.TaskList;

import static Duke.TaskList.*;

public class Parser {
    private static ArrayList<Task> list = new ArrayList<>();

    public static int parseCommand(String userInput, int noOfTask) {
        int divider = userInput.indexOf(" ");

        //If user inputted list, return list of items
        if (userInput.contains("list")) {
            listTask(noOfTask);

            //If user inputted done, then mark the task as done
        } else if (userInput.contains("done")) {
            doneTask(userInput, noOfTask, divider);

            //If user inputted deadline, then add the task under deadline cat
        } else if (userInput.contains("deadline")) {
            noOfTask = createDeadline(userInput, noOfTask, divider);

            //If user inputted to do, then add the task under to do cat
        } else if (userInput.contains("todo")) {
            noOfTask = createTodo(userInput, noOfTask, divider);

            //If user inputted event, then add task under event cat
        } else if (userInput.contains("event")) {
            noOfTask = createEvent(userInput, noOfTask, divider);

            //If user inputted delete, then delete the item
        } else if (userInput.contains("delete")) {
            noOfTask = deleteTask(userInput, noOfTask, divider);

            //Else, throw a random word exception
        } else if(userInput.equals("bye")) {
            return 0;

        } else {
                new Exception("random", null);
            }
        return noOfTask;
    }
}
