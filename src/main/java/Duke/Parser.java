package Duke;

import java.util.ArrayList;

import static Duke.TaskList.createDeadline;
import static Duke.TaskList.createEvent;
import static Duke.TaskList.createTodo;
import static Duke.TaskList.deleteTask;
import static Duke.TaskList.doneTask;
import static Duke.TaskList.findTask;
import static Duke.TaskList.listTask;

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

        } else if (userInput.contains("find")) {
            findTask(userInput, noOfTask, divider);

        //If user inputted bye, return 0 and break out of loop
        } else if(userInput.equals("bye")) {
            return 0;

        //Else, throw a random word exception
        } else {
                new Exception("random", null);
        }
        return noOfTask;
    }
}