package Duke;

import java.util.ArrayList;

import static Duke.TaskList.createDeadline;
import static Duke.TaskList.createEvent;
import static Duke.TaskList.createTodo;
import static Duke.TaskList.deleteTask;
import static Duke.TaskList.doneTask;
import static Duke.TaskList.findTask;
import static Duke.TaskList.listTask;

/**
 * This programme is used to filter the commands given by the user input
 * and carry out the respective actions
 */
public class Parser {
    private static ArrayList<Task> list = new ArrayList<>();

    /**
     * Used to filter the commands given by the user.
     *
     * @param userInput the line inputted by the user.
     * @param noOfTask the number of task in the ArrayList list.
     * @return noOfTask tasks in the array list if any task were added/deleted.
     * @throws Exception random error if the user did not input the command correctly.
     */
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

        //If the user inputted find, then find the tasks with the relevant string
        } else if (userInput.contains("find")) {
            findTask(userInput, noOfTask, divider);

        //If user inputted bye, return 0 and break out of loop
        } else if(userInput.equals("bye")) {
            return 0;

        } else {
                new Exception("random", null);
            }
        return noOfTask;
    }
}
