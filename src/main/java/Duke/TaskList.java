package Duke;

import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();

    public TaskList(ArrayList<Task> inputList) {
        list = inputList;
    }

    public static int createEvent(String line, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("event") || line.equals("event ")
                || line.endsWith("/at") || line.endsWith("/at ")) {
            new Exception("description", "event");

        //Run date error
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "event");

        //If no error, run code to store event
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

    public static int createTodo(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("todo") || line.equals("todo ")) {
            new Exception("description", "todo");

        //If no error, run code to store to do
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

    public static int createDeadline(String line, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("deadline") || line.equals("deadline ")) {
            new Exception("description", "deadline");

        //Run date error
        } else if (line.endsWith("/by") || line.endsWith("/by ")
                || line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "deadline");

        //If no error, run code to store deadline
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

    public static void doneTask(String line, int noOfTask, int divider) {

        //Run description error
        if (line.equals("done") || line.equals("done ")) {
            new Exception("description", "done");

        //Run empty list error
        } else if (noOfTask == 0) {
            new Exception("empty", null);

        //If no description error, run code to tick done
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

    public static ArrayList<Task> filterByString(ArrayList<Task> tasksData, String filterString) {
        ArrayList<Task> filterTaskList = (ArrayList<Task>)tasksData.stream()
                .filter((s) -> s.getDescription().contains(filterString))
                .collect(toList());

        return filterTaskList;
    }
}
