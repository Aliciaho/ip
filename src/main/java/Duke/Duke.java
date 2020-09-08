package Duke;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String userInput;
        Task[] list = new Task[100];
        int noOfTask = 0;
        Scanner in = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);

        //Get input from user
        System.out.println("Hello! I'm Duke.Duke");
        System.out.println("What can I do for you?");
        userInput = in.nextLine();
        int divider = userInput.indexOf(" ");

        //If bye was not inputted, ask for input again
        while (!userInput.equals("bye")) {

            //If user inputted list, return list of items
            if (userInput.contains("list")) {
                listTask(list, noOfTask);

            //If user inputted done, then mark the task as done
            } else if (userInput.contains("done")) {
                doneTask(userInput, list, divider);

            //If user inputted deadline, then add the task under deadline cat
            } else if (userInput.contains("deadline")) {
                noOfTask = Deadline(userInput, list, noOfTask, divider);

            //If user inputted to do, then add the task under to do cat
            } else if (userInput.contains("todo")) {
                noOfTask = Todo(userInput, list, noOfTask, divider);

            //If user inputted event, then add task under event cat
            } else if (userInput.contains("event")) {
                noOfTask = Event(userInput, list, noOfTask, divider);

            //else print added statement and add the item to list
            } else {
                new Exception("random", null);
            }
            userInput = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static int Event(String line, Task[] list, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("event") || line.equals("event ")) {
            new Exception("description", "event");

        //Run date error
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "event");

        //If no error, run code to store event
        } else {
            list[noOfTask] = new Event(line.substring((divider + 1),
                    (dividerDate - 1)), line.substring(dividerDate + 4));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list[noOfTask - 1]);
            if ((noOfTask - 1) == 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    private static int Todo(String line, Task[] list, int noOfTask, int divider) {

        //Run description error
        if (line.equals("todo") || line.equals("todo ")) {
            new Exception("description", "todo");

        //If no error, run code to store to do
        } else {
            list[noOfTask] = new Todo(line.substring(divider + 1));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list[noOfTask - 1]);
            if ((noOfTask - 1) == 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    private static int Deadline(String line, Task[] list, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");

        //Run description error
        if (line.equals("deadline") || line.equals("deadline ")) {
            new Exception("description", "deadline");

        //Run date error
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "deadline");

        //If no error, run code to store deadline
        } else {
            list[noOfTask] = new Deadline(line.substring((divider + 1),
                    (dividerDate - 1)), line.substring(dividerDate + 4));
            noOfTask++;
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + list[noOfTask - 1]);
            if ((noOfTask - 1) <= 0) {
                System.out.println("Now you have " + noOfTask + " task in the list.");
            } else {
                System.out.println("Now you have " + noOfTask + " tasks in the list.");
            }
        }
        return noOfTask;
    }

    private static void doneTask(String line, Task[] list, int divider) {

        //Run description error
        if (line.equals("done") || line.equals("done ")) {
            new Exception("description", "done");

        //If no description error, run code to tick done
        } else {
            try {
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                list[taskNumber - 1].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + list[taskNumber - 1]);

            //If no number is input, throw error
            } catch (NumberFormatException e) {
                System.out.println("Please input the task number!");
            }
        }
    }

    private static void listTask(Task[] list, int noOfTask) {

        //Run empty error
        if (noOfTask == 0) {
            new Exception("empty", null);

        //If no error, run code to list task
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < noOfTask; i++) {
                int listNumber = i + 1;
                System.out.println(listNumber + "." + list[i]);
            }
        }
    }
}
