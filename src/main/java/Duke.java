import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String line;
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
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        line = in.nextLine();
        int divider = line.indexOf(" ");

        //If bye was not inputted, ask for input again
        while (!line.equals("bye")) {
            //If user inputted list, return list of items
            if (line.contains("list")) {
                listTask(list, noOfTask);
            //If user inputted done, then mark the task as done
            } else if (line.contains("done")) {
                doneTask(line, list, divider);
            //If user inputted deadline, then add the task under deadline cat
            } else if (line.contains("deadline")) {
                noOfTask = Deadline(line, list, noOfTask, divider);
            //If user inputted to do, then add the task under to do cat
            } else if (line.contains("todo")) {
                noOfTask = Todo(line, list, noOfTask, divider);
            //If user inputted event, then add task under event cat
            } else if (line.contains("event")) {
                noOfTask = Event(line, list, noOfTask, divider);
            //else print added statement and add the item to list
            } else {
                new Exception("random", null);
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static int Event(String line, Task[] list, int noOfTask, int divider) {
        int dividerDate = line.indexOf("/");
        if (line.equals("event") || line.equals("event ")) {
            new Exception("description", "event");
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "event");
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
        if (line.equals("todo") || line.equals("todo ")) {
            new Exception("description", "todo");
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
        if (line.equals("deadline") || line.equals("deadline ")) {
            new Exception("description", "deadline");
        } else if (line.endsWith("/") || line.endsWith("/ ")) {
            new Exception("date", "deadline");
        } else {
            list[noOfTask] = new Deadline(line.substring((divider + 1),
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

    private static void doneTask(String line, Task[] list, int divider) {
        if (line.equals("done") || line.equals("done ")) {
            new Exception("description", "done");
        } else {
            try {
                int taskNumber = Integer.parseInt(line.substring(divider + 1));
                list[taskNumber - 1].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + list[taskNumber - 1]);
            } catch (NumberFormatException e) {
                System.out.println("Please input the task number!");
            }
        }
    }

    private static void listTask(Task[] list, int noOfTask) {
        if (noOfTask == 0) {
            new Exception("empty", null);
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < noOfTask; i++) {
                int listNumber = i + 1;
                System.out.println(listNumber + "." + list[i]);
            }
        }
    }
}
