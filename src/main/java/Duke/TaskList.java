package Duke;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

/**
 * This programme is to process the respective commands given by the user
 * A new Event/To do/Deadline can be created if the user inputted so
 * If the user inputs list, the tasks in the ArrayList will be listed out
 * If the user inputted find, the relevant tasks containing the keyword will be listed out
 * If the user inputted deleted, the respective task is deleted from the ArrayList
 * and removed from the textfile
 * If the user inputted done, the respective task is mark done and the textfile is updated accordingly
 */
public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();

    /**
     * Constructor that is used to initialised the ArrayList list as the inputted list from the main code
     *
     * @param inputList inputted list from the main code.
     */
    public TaskList(ArrayList<Task> inputList) {
        list = inputList;
    }

    /**
     * Returns the number of task in the current list after creating an event.
     * Used to create a new Event Task and store it in the ArrayList list.
     *
     * @param line user input.
     * @param noOfTask number of task in the current list.
     * @param divider the index of the first blank space in the user input.
     * @return noOfTask number of task in the current list after adding a new Event.
     * @throws Exception description error when no description is written.
     * @throws Exception date error when no date is written.
     */
    public static int createEvent(String line, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("event") || line.equals("event ")
                || line.endsWith("/at") || line.endsWith("/at ")) {
            new Exception("description", "event");

        //Run date error
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "event");

        //If no error, run code to store event in array list
        } else {
            list.add(noOfTask, new Event(line.substring((divider + 1),
                    (dividerDate - 1)), line.substring(dividerDate + 4)));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list.get(noOfTask-1));
            if ((noOfTask - 1) == 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    /**
     * Returns the number of task in the current list after creating a to do.
     * Used to create a new To do Task and store it in the ArrayList list.
     *
     * @param line user input.
     * @param noOfTask number of task in the current list.
     * @param divider the index of the first blank space in the user input.
     * @return noOfTask number of task in the current list after adding a new To do.
     * @throws Exception description error when no description is written.
     */
    public static int createTodo(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("todo") || line.equals("todo ")) {
            new Exception("description", "todo");

        //If no error, run code to store to do in array list
        } else {
            list.add(noOfTask, new Todo(line.substring(divider + 1)));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list.get(noOfTask-1));
            if ((noOfTask - 1) == 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    /**
     * Returns the number of task in the current list after creating a deadline.
     * Used to create a new Deadline Task and store it in the ArrayList list.
     *
     * @param line user input.
     * @param noOfTask number of task in the current list.
     * @param divider the index of the first blank space in the user input.
     * @return noOfTask number of task in the current list after adding a new Deadline.
     * @throws Exception description error when no description is written.
     * @throws Exception date error when no date is written.
     */
    public static int createDeadline(String line, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("deadline") || line.equals("deadline ")) {
            new Exception("description", "deadline");

        //Run date error
        } else if (line.endsWith("/by") || line.endsWith("/by ")
                || line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "deadline");

        //If no error, run code to store deadline in array list
        } else {
            list.add(noOfTask, new Deadline(line.substring((divider + 1),
                    (dividerDate - 1)), line.substring(dividerDate + 4)));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list.get(noOfTask-1));
            if ((noOfTask - 1) <= 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    /**
     * Used to mark a task as done which is shown in the form of a tick.
     *
     * @param line user input.
     * @param noOfTask number of task in the current list.
     * @param divider the index of the first blank space in the user input.
     * @throws Exception description error when no description is written.
     * @throws Exception empty error if the list is empty.
     */
    public static void doneTask(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("done") || line.equals("done ")) {
            new Exception("description", "done");

        //Run empty list error
        } else if (noOfTask == 0) {
            new Exception("empty", null);

        //If no description error, run code to tick done for the respective task
        } else {
            try {
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                list.get(taskNumber-1).setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + list.get(taskNumber-1));

            //If no number is input, throw error
            } catch (NumberFormatException e) {
                System.out.println("Please input the task number!");
            }
        }
    }

    /**
     * Returns the number of task in the current list after deleting the task.
     * Used to delete a Task and remove it from the ArrayList list.
     *
     * @param line user input.
     * @param noOfTask number of task in the current list.
     * @param divider the index of the first blank space in the user input.
     * @return noOfTask number of task in the current list after deleting a task.
     * @throws Exception description error when no description is written.
     * @throws Exception empty error if the list is empty.
     */
    public static int deleteTask(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("delete") || line.equals("delete ")) {
            new Exception("description", "delete");

        //Run empty list error
        } else if (noOfTask == 0) {
            new Exception("empty", null);

        //If no error, run code to delete task
        } else {
            try {
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                System.out.println("Noted. I've removed this task:");
                System.out.println("  " + list.get(taskNumber-1));
                list.remove(taskNumber-1);
                noOfTask --;
                if ((noOfTask - 1) <= 0) {
                    System.out.println("Now you have " + noOfTask + " task in the list.");
                } else {
                    System.out.println("Now you have " + noOfTask + " tasks in the list.");
                }

                //If no number is input, throw error
            } catch (NumberFormatException e) {
                System.out.println("Please input the task number!");
            }
        }
        return noOfTask;
    }

    /**
     * Used to list out all the tasks in the current list.
     *
     * @param noOfTask number of task in the current list.
     * @throws Exception empty error if the list is empty.
     */
    public static void listTask(int noOfTask) {

        //Run empty list error
        if (noOfTask == 0) {
            new Exception("empty", null);

        //If no error, run code to list task
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < noOfTask; i++) {
                int listNumber = i + 1;
                System.out.println(listNumber + "." + list.get(i));
            }
        }
    }

    /**
     * Used to find a task in the ArrayList list by entering a keyword.
     *
     * @param line user input.
     * @param noOfTask number of task in the current list.
     * @param divider the index of the first blank space in the user input.
     * @param noOfTask number of task in the current list.
     * @throws Exception empty error if the list is empty.
     * @throws Exception description error if no description was written.
     */
    public static void findTask(String line, int noOfTask, int divider) {

        //Run empty list error
        if (noOfTask == 0) {
            new Exception("empty", null);

        //Run description error
        } else if (line.equals("find") || line.equals("find ")) {
            new Exception("description", "find");

        //If no error, run code to filter task
        } else {
            int index = 1;
            System.out.println("Here are the matching tasks in your list:");
            for(Task t: filterByString(list,line.substring(divider+1))) {
                System.out.println(index + "." + t);
                index ++;
            }

        }
    }

    /**
     * Used to filter the ArrayList list by the keyword inputted by the user.
     *
     * @param tasksData the tasks stored in the ArrayList list.
     * @param filterString the keyword that the user inputted.
     * @return filterTaskList tasks in the array list that contains the keyword inputted by user.
     */
    public static ArrayList<Task> filterByString(ArrayList<Task> tasksData, String filterString) {
        ArrayList<Task> filterTaskList = (ArrayList<Task>)tasksData.stream()
                .filter((s) -> s.getDescription().contains(filterString))
                .collect(toList());

        return filterTaskList;
    }
}
